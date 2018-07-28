package org.uniton.gr8.sansulbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.uniton.gr8.sansulbackend.vo.RawRoom;

@CrossOrigin(origins = "*")
@RestController
public class RoomController {
    @PostMapping("/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public int createRoom() {
        int roomId = 0;
        return roomId;
    }

    @GetMapping("/rooms/{roomId}")
    public String getRoom(@PathVariable(name = "roomId") int roomId) {
        // FIXME: room id에 해당하는 room이 없으면 exception
        return "";
    }

    @PutMapping("/rooms/{roomId}")
    public RawRoom updateRoom(@PathVariable(name = "roomId") int roomId) {
        RawRoom rawRoom = new RawRoom();
        rawRoom.setRoomId(0);
        rawRoom.setTotalPrice(10000);
        rawRoom.setDrinkPrice(5000);
        rawRoom.setSnackPrice(5000);
        return rawRoom;
    }
}
