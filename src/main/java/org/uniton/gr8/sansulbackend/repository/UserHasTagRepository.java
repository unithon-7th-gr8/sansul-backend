package org.uniton.gr8.sansulbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uniton.gr8.sansulbackend.dto.UserHasTag;

public interface UserHasTagRepository extends JpaRepository<UserHasTag, Integer> {
}
