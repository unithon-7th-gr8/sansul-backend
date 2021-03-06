package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniton.gr8.sansulbackend.domain.TagType;
import org.uniton.gr8.sansulbackend.dto.User;
import org.uniton.gr8.sansulbackend.dto.UserHasTag;
import org.uniton.gr8.sansulbackend.repository.UserRepository;
import org.uniton.gr8.sansulbackend.vo.RawUser;
import org.uniton.gr8.sansulbackend.vo.UserData;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHasTagService userHasTagService;

    @Override
    public User addUser(RawUser rawUser) {

        final User user = userRepository.save(toUser(rawUser));

        rawUser.getTags().stream()
                .map(TagType::valueOf)
                .map((tag) -> UserHasTag.builder()
                        .tagId(tag.intValue())
                        .userId(user.getUserId())
                        .build())
                .forEach(userHasTagService::addUserHasTag);

        return user;
    }

    public User updateUser(int userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException());

        user.setPaid(true);
        user = userRepository.save(user);
        return user;
    }

    public List<UserData> findUserBy(int roomId){

        List<UserData> list = new ArrayList<>();

        userRepository.findAllByRoomId(roomId).stream()
                .map(this::toUserData)
                .forEach(list::add);

        return list;
    }

    public boolean isAllPaid(int roomId){
        boolean result = true;
        for(User user : userRepository.findAllByRoomId(roomId))
            result = result && user.isPaid();

        return result;
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }

    private User toUser(RawUser rawUser) {

        return User.builder()
                .name(rawUser.getName())
                .roomId(rawUser.getRoomId())
                .isPaid(false)
                .build();
    }

    private UserData toUserData(User user){
        List<String> tags = new ArrayList<>();

        user.getTags().stream()
                .map(tag -> TagType.valueOf(tag.getTagId()))
                .map(tag -> tag.name())


                .forEach(tags::add);

        return UserData.builder()
                .userId(user.getUserId())
                .billedPrice(user.getBilledPrice())
                .isPaid(user.isPaid())
                .roomId(user.getRoomId())
                .name(user.getName())
                .userId(user.getUserId())
                .tags(tags)
                .build();
    }
}
