package org.uniton.gr8.sansulbackend.dto;

import lombok.Data;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "billed_price")
    private int billedPrice;

    @Column(name = "is_paid")
    private boolean isPaid;

    @Column(name = "room_id")
    private int room_id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tag",
            joinColumns =  @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
}
