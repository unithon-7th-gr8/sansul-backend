package org.uniton.gr8.sansulbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.uniton.gr8.sansulbackend.dto.Tag;
import org.uniton.gr8.sansulbackend.dto.User;

import java.util.List;

@Service
public class CalculationService {
    // 1의자리까지 표현 (소수점 첫째자리는 버림)
    public int calculateNormalPrice(List<User> users, int totalPrice) {
        if (CollectionUtils.isEmpty(users)) {
            throw new RuntimeException("user list is empty.");
        }

        int numberOfUsers = users.size();
        double discountedPriceRatio = users.stream()
                                           .map(this::getDiscountRatio)
                                           .reduce((x, y) -> x + y)
                                           .orElse(0.0);


        return (int) (totalPrice / (double) numberOfUsers - discountedPriceRatio);
    }

    private double getDiscountRatio(User user) {
        return user.getTags().stream()
                   .map(Tag::getRatio)
                   .reduce((x, y) -> x + y)
                   .filter(o -> o < 1)
                   .orElse(1.0);
    }
}
