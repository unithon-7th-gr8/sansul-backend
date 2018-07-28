package org.uniton.gr8.sansulbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.uniton.gr8.sansulbackend.dto.Room;
import org.uniton.gr8.sansulbackend.dto.User;
import org.uniton.gr8.sansulbackend.repository.RoomRepository;
import org.uniton.gr8.sansulbackend.service.RoomService;
import org.uniton.gr8.sansulbackend.service.UserService;
import org.uniton.gr8.sansulbackend.vo.Price;
import org.uniton.gr8.sansulbackend.vo.RawRoom;
import org.uniton.gr8.sansulbackend.vo.TotalData;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired private UserService userService;

    @PostMapping("/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public int createRoom() {
        int roomId = roomService.createRoom();
        return roomId;
    }

    @GetMapping("/rooms/{roomId}")
    public TotalData room(@PathVariable(name = "roomId") int roomId) {
        return roomService.makeToTalData(roomId);
    }

    @PutMapping("/rooms/{roomId}")
    public Room updateRoom(@PathVariable(name = "roomId") int roomId, @RequestBody Price price) {

        int price_total = price.getTotalPrice();
        int price_drink = price.getDrinkPrice();
        int price_snack = price.getSnackPrice();

        if(price_total == 0)
            throw new IllegalStateException();

        if(price_snack + price_drink == 0) {
            price_snack = price_total / 2;
            price_drink = price_total - price_snack;
        }

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalStateException("방 번호 잘못 입력함 "));

        room.setTotalPrice(price_total);
        room.setDrinkPrice(price_drink != 0 ? price_drink : price_total - price_snack);
        room.setSnackPrice(price_snack != 0 ? price_snack : price_total - price_drink);

        roomRepository.save(room);

        return room;
    }
}
