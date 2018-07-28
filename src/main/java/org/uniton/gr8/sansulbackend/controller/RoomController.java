package org.uniton.gr8.sansulbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public String getRoom() {
        // FIXME: room id에 해당하는 room이 없으면 exception
        return "";
    }
}
