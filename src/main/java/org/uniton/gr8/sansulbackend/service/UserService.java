package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniton.gr8.sansulbackend.repository.UserRepository;
import org.uniton.gr8.sansulbackend.vo.RawUser;

@Service
public interface UserService {

    int addUser(RawUser rawUser);
}
