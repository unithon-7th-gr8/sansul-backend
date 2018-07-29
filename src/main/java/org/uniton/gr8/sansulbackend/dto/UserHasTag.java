package org.uniton.gr8.sansulbackend.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
public class UserHasTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userHasTagId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "tag_id")
    private int tagId;
}
