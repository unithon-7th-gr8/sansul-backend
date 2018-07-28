package org.uniton.gr8.sansulbackend.vo;

import lombok.Builder;
import lombok.Value;
import org.uniton.gr8.sansulbackend.domain.RoomStatus;
import org.uniton.gr8.sansulbackend.dto.User;

import java.util.List;

@Value
public class Price {
    private int totalPrice;
    private int drinkPrice;
    private int snackPrice;
}
