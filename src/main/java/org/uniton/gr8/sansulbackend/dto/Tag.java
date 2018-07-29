package org.uniton.gr8.sansulbackend.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Tag {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;

    @Column(name = "ratio")
    private double ratio;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private List<User> users;
}
