package org.uniton.gr8.sansulbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uniton.gr8.sansulbackend.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
