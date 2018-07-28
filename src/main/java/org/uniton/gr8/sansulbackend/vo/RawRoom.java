package org.uniton.gr8.sansulbackend.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.uniton.gr8.sansulbackend.dto.Room;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawRoom {
    private int roomId;
    private int totalPrice;
    private int drinkPrice;
    private int snackPrice;

    public static RawRoom from(Room room) {
        RawRoom rawRoom = new RawRoom();
        rawRoom.setRoomId(room.getRoomId());
        rawRoom.setTotalPrice(room.getTotalPrice());
        rawRoom.setDrinkPrice(room.getDrinkPrice());
        rawRoom.setSnackPrice(room.getSnackPrice());
        return rawRoom;
    }


}
