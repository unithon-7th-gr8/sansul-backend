package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniton.gr8.sansulbackend.dto.User;
import org.uniton.gr8.sansulbackend.repository.UserRepository;
import org.uniton.gr8.sansulbackend.vo.RawUser;
import org.uniton.gr8.sansulbackend.vo.UserData;

import java.util.List;

@Service
public class UserServiceDup implements UserService{

    UserServiceImpl userServiceImpl;
    @Autowired UserRepository userRepository;

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public User addUser(RawUser rawUser) {
        List<User> users = userRepository.findAllByRoomIdAndName(rawUser.getRoomId(), rawUser.getName());

        int size = users.size();

        if(size != 0)
            rawUser.setName(rawUser.getName() + (size - 1));

        return userServiceImpl.addUser(rawUser);
    }

    @Override
    public List<UserData> findUserBy(int roomId) {
        return userServiceImpl.findUserBy(roomId);
    }

    @Override
    public void deleteUser(int userId) {
        userServiceImpl.deleteUser(userId);
    }
}
