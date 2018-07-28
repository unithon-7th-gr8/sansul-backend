package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.uniton.gr8.sansulbackend.repository.UserRepository;
import org.uniton.gr8.sansulbackend.vo.RawUser;

public class UserServiceImpl implements UserService{

    @Autowired private UserRepository userRepository;

    @Override
    public int addUser(RawUser rawUser) {
        return 0;
    }
}
