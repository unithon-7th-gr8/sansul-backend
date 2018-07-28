package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniton.gr8.sansulbackend.domain.TagType;
import org.uniton.gr8.sansulbackend.dto.User;
import org.uniton.gr8.sansulbackend.dto.UserHasTag;
import org.uniton.gr8.sansulbackend.repository.UserRepository;
import org.uniton.gr8.sansulbackend.vo.RawUser;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHasTagService userHasTagService;

    @Override
    public int addUser(RawUser rawUser) {

        final User user = userRepository.save(toUser(rawUser));

        rawUser.getTags().stream()
                .map(TagType::valueOf)
                .map((tag) -> UserHasTag.builder()
                        .tagId(tag.intValue())
                        .userId(user.getUserId())
                        .build())
                .forEach(userHasTagService::addUserHasTag);

        return user.getUserId();
    }

    public User toUser(RawUser rawUser) {

        return User.builder()
                .name(rawUser.getName())
                .roomId(rawUser.getRoomId())
                .build();
    }
}
