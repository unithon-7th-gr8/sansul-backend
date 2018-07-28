package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniton.gr8.sansulbackend.dto.UserHasTag;
import org.uniton.gr8.sansulbackend.repository.UserHasTagRepository;

@Service
public class UserHasTagService {

    @Autowired private UserHasTagRepository userHasTagRepository;

    public void addUserHasTag(UserHasTag userHasTag){
        userHasTagRepository.save(userHasTag);
    }
}
