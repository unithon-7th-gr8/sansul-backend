package org.uniton.gr8.sansulbackend.dto;

import lombok.Data;
import org.uniton.gr8.sansulbackend.domain.RoomStatus;

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
//    @OneToMany
//    @JoinColumn(name = "room_id")      // user 입장에서 room을 바라보는 column
//    private List<User> users;
    private int totalPrice;
    private int drinkPrice;
    private int snackPrice;
}
