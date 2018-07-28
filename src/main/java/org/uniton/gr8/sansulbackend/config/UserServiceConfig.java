package org.uniton.gr8.sansulbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.uniton.gr8.sansulbackend.service.UserService;
import org.uniton.gr8.sansulbackend.service.UserServiceDup;
import org.uniton.gr8.sansulbackend.service.UserServiceImpl;

@Configuration
public class UserServiceConfig {

    @Bean
    public UserServiceImpl userServiceImpl(){
        return new UserServiceImpl();
    }

    @Bean
    public UserServiceDup userService(@Autowired UserServiceImpl userServiceImpl){
        UserServiceDup userServiceDup = new UserServiceDup();
        userServiceDup.setUserServiceImpl(userServiceImpl);
        return userServiceDup;
    }
}
