package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniton.gr8.sansulbackend.repository.UserRepository;
import org.uniton.gr8.sansulbackend.vo.RawUser;

@Service
public class UserServiceDup implements UserService{

    @Autowired UserServiceImpl userService;
    @Autowired UserRepository userRepository;

    @Override
    public int addUser(RawUser rawUser) {

        return 0;
    }
}
