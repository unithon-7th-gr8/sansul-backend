package org.uniton.gr8.sansulbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniton.gr8.sansulbackend.domain.RoomStatus;
import org.uniton.gr8.sansulbackend.dto.Room;
import org.uniton.gr8.sansulbackend.repository.RoomRepository;
import org.uniton.gr8.sansulbackend.repository.UserRepository;
import org.uniton.gr8.sansulbackend.vo.TotalData;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public int createRoom() {
        Room room = new Room();
        room.setRoomStatus(RoomStatus.OPEN);
        room.setSnackPrice(0);
        room.setDrinkPrice(0);
        room.setTotalPrice(0);
        roomRepository.save(room);
        return room.getRoomId();
    }
    public TotalData makeToTalData(int roomId){
        Room room = roomRepository.findById(roomId).orElse(null);

        return TotalData.builder()
                .roomId(roomId)
                .roomStatus(room.getRoomStatus())
                .totalPrice(room.getTotalPrice())
                .drinkPrice(room.getDrinkPrice())
                .snackPrice(room.getSnackPrice())
                .users(userService.findUserBy(roomId))
                .build();
    }
}
