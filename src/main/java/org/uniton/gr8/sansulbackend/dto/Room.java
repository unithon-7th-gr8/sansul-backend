package org.uniton.gr8.sansulbackend.dto;

import lombok.Data;
import org.uniton.gr8.sansulbackend.domain.RoomStatus;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "drink_price")
    private int drinkPrice;

    @Column(name = "snack_price")
    private int snackPrice;

    @OneToMany
    @JoinColumn(name = "room_id")      // user 입장에서 room을 바라보는 column
    private List<User> users;
}
