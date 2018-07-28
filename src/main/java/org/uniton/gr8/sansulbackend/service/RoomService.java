package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniton.gr8.sansulbackend.domain.RoomStatus;
import org.uniton.gr8.sansulbackend.dto.Room;
import org.uniton.gr8.sansulbackend.repository.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public int createRoom() {
        Room room = new Room();
        room.setRoomStatus(RoomStatus.OPEN);
        room.setSnackPrice(0);
        room.setDrinkPrice(0);
        room.setTotalPrice(0);
        roomRepository.save(room);
        return room.getRoomId();
    }
}
