package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.uniton.gr8.sansulbackend.dto.Room;
import org.uniton.gr8.sansulbackend.dto.Tag;
import org.uniton.gr8.sansulbackend.dto.User;
import org.uniton.gr8.sansulbackend.repository.RoomRepository;
import org.uniton.gr8.sansulbackend.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public void calculate(int roomId) {
        // find user by room id
        Room room = roomRepository.findById(roomId)
                                  .orElseThrow(RuntimeException::new);

        List<User> users = userRepository.findAllByRoomId(roomId);
        if (CollectionUtils.isEmpty(users)) {
            throw new RuntimeException("users is empty");
        }

        int totalPrice = room.getTotalPrice();
        int snackPrice = room.getSnackPrice();
        int drinkPrice = room.getDrinkPrice();

        if (room.getDrinkPrice() > 0 && room.getSnackPrice() > 0) {
            applyDrinkPrice(users, drinkPrice);
            applySnackPrice(users, snackPrice);
        } else {
            // 아마 실행되지않음
            int normalPrice = calculateNormalPrice(users, totalPrice);
            applyNormalPrice(users, normalPrice);
        }
    }

    // 1의자리까지 표현 (소수점 첫째자리는 버림)
    // normal price = 1.0 인분
    public int calculateNormalPrice(List<User> users, int totalPrice) {
        if (CollectionUtils.isEmpty(users)) {
            throw new RuntimeException("user list is empty.");
        }
        if (totalPrice == 0) {
            throw new RuntimeException("totalPrice cannot be zero.");
        }
        if (users.size() == 1) {
            return totalPrice;
        }

        int numberOfUsers = users.size();
        double discountedPriceRatio = users.stream()
                                           .map(this::getDiscountRatio)
                                           .reduce((x, y) -> x + y)
                                           .orElse(0.0);

        return (int) (totalPrice / ((double) numberOfUsers - discountedPriceRatio));
    }

    private void applyNormalPrice(List<User> users, int price) {
        users.forEach(user -> {
            int billedPrice = user.getBilledPrice();
            user.setBilledPrice(billedPrice + (int) ((double) price * (1.0 - getDiscountRatio(user))));
            userRepository.saveAndFlush(user);
        });
    }

    private void applyDrinkPrice(List<User> users, int drinkPrice) {
        List<User> drunkenUsers = users.stream()
                                       .filter(o -> !o.getTags().stream()
                                                      .map(Tag::getTagId)
                                                      .anyMatch(tagId -> tagId == 2))   // 안마신사람 아니면
                                       .collect(Collectors.toList());
        int drinkNormalPrice = calculateNormalPrice(drunkenUsers, drinkPrice);  // 술 1인분
        applyNormalPrice(users, drinkNormalPrice);
    }

    private void applySnackPrice(List<User> users, int snackPrice) {
        List<User> snackUsers = users.stream()
                                       .filter(o -> !o.getTags().stream()
                                                      .map(Tag::getTagId)
                                                      .anyMatch(tagId -> tagId == 4))   // 안먹은사람 아니면
                                       .collect(Collectors.toList());
        int snackNormalPrice = calculateNormalPrice(snackUsers, snackPrice);    // 술 1인분
        applyNormalPrice(users, snackNormalPrice);
    }

    public int calculateBilledPrice(User user, int normalPrice) {
        return (int) (normalPrice * (1 - getDiscountRatio(user)));
    }

    private double getDiscountRatio(User user) {
        if (CollectionUtils.isEmpty(user.getTags())) {
            return 0.0;
        }
        return user.getTags().stream()
                   .map(Tag::getRatio)
                   .reduce((x, y) -> x + y)
                   .map(o -> Math.min(1.0, o))
                   .orElse(0.0);

    }
}