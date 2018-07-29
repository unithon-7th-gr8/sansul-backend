package org.uniton.gr8.sansulbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uniton.gr8.sansulbackend.dto.Room;
import org.uniton.gr8.sansulbackend.repository.RoomRepository;
import org.uniton.gr8.sansulbackend.service.RoomService;

@Controller
@RequestMapping("route")
public class PageController {

    @Autowired private RoomRepository roomRepository;

    @RequestMapping("{roomId}")
    public String route(Model model, @PathVariable(name = "roomId") int roomId){
        Room room = roomRepository.findById(roomId).orElse(null);
        String path = "";

        switch(room.getRoomStatus()){
            case OPEN: return path + "edit.html";
            case CLOSED: return path + "result.html";
            case FINISH: return path + "finish.html";
            default: throw new IllegalStateException();
        }
    }

}
