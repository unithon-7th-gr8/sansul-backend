package org.uniton.gr8.sansulbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uniton.gr8.sansulbackend.dto.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByRoomId(Integer roomId);
    List<User> findAllByRoomIdAndName(Integer roomId, String name);
}
