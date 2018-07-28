package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniton.gr8.sansulbackend.dto.User;
import org.uniton.gr8.sansulbackend.repository.UserRepository;
import org.uniton.gr8.sansulbackend.vo.RawUser;
import org.uniton.gr8.sansulbackend.vo.UserData;

import java.util.List;

@Service
public interface UserService {

    User addUser(RawUser rawUser);
    List<UserData> findUserBy(int roomId);
    void deleteUser(int userId);
}
