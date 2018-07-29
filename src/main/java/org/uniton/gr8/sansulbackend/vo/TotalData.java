package org.uniton.gr8.sansulbackend.vo;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.uniton.gr8.sansulbackend.domain.RoomStatus;
import org.uniton.gr8.sansulbackend.dto.Room;
import org.uniton.gr8.sansulbackend.dto.User;

import java.util.List;

@Value
@Builder
public class TotalData {
    private int roomId;
    private RoomStatus roomStatus;

    private int totalPrice;
    private int drinkPrice;
    private int snackPrice;

    private List<UserData> users;
}
