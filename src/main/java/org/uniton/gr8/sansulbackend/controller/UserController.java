package org.uniton.gr8.sansulbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uniton.gr8.sansulbackend.dto.User;
import org.uniton.gr8.sansulbackend.service.UserService;
import org.uniton.gr8.sansulbackend.vo.RawUser;
import org.uniton.gr8.sansulbackend.vo.UserData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("rooms")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(value = "{roomId}/users", method = RequestMethod.GET)
    public List<User> users(@PathVariable("roomId") int roomId){
        return userService.findUserBy(roomId);
    }

    @RequestMapping(value = "{roomId}/users", method = RequestMethod.POST)
    public ResponseEntity<?> putUser(@PathVariable("roomId") int roomId, @RequestBody RawUser rawUser){

        rawUser.setRoomId(roomId);
        User user = userService.addUser(rawUser);

        Map<String, Integer> response = new HashMap<>();
        response.put("userId", user.getUserId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping(value = "{roomId}/users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "{roomId}/users/{userId}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable("roomId") int roomId, @PathVariable("userId") int userId){
        return userService.updateUser(userId);
    }

}
