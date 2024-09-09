package com.reservation.api.controllers;

import com.reservation.api.dto.RoomDto;
import com.reservation.api.models.Room;
import com.reservation.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("room")
    public ResponseEntity<List<Room>> getRooms() {
        List<Room> rooms = roomService.getRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("room/{id}")
    public ResponseEntity<Room> roomDetail(@PathVariable int id) {
        try {
            Room room = roomService.getRoomById(id);

            return new ResponseEntity<>(room, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("room/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto) {
        return new ResponseEntity<>(roomService.createRoom(roomDto), HttpStatus.CREATED);
    }

    @GetMapping("room/search")
    public ResponseEntity<List<Room>> getRoomsBetweenDates(@RequestParam String checkIn, @RequestParam String checkOut, @RequestParam int guests) {
        List<Room> rooms = roomService.getRoomsBetweenDates(checkIn, checkOut, guests);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
