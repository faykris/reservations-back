package com.reservation.api.service.impl;

import com.reservation.api.dto.RoomDto;
import com.reservation.api.models.Room;
import com.reservation.api.repository.RoomRepository;
import com.reservation.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setName(roomDto.getName());
        room.setDescription(roomDto.getDescription());
        room.setUrlImage(roomDto.getUrlImage());
        room.setPrice(roomDto.getPrice());
        room.setMaxGuests(roomDto.getMaxGuests());

        Room newRoom = roomRepository.save(room);

        RoomDto roomResponse = new RoomDto();
        roomResponse.setId(newRoom.getId());
        roomResponse.setName(newRoom.getName());
        roomResponse.setUrlImage(newRoom.getUrlImage());
        roomResponse.setDescription(newRoom.getDescription());
        roomResponse.setPrice(newRoom.getPrice());
        roomResponse.setMaxGuests(newRoom.getMaxGuests());

        return roomResponse;
    }

    @Override
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(int id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + id));
    }

    @Override
    public List<Room> getRoomsBetweenDates(String checkIn, String checkOut, int guests) {
        String checkInDateStr = checkIn.substring(0, 10);
        String checkOutDateStr = checkOut.substring(0, 10);

        LocalDate checkInDate = LocalDate.parse(checkInDateStr);
        LocalDate checkOutDate = LocalDate.parse(checkOutDateStr);

        LocalDateTime checkInDateTime = checkInDate.atTime(15, 0);

        LocalDateTime checkOutDateTime = checkOutDate.atTime(11, 0);

        return roomRepository.findAvailableRoomsBetweenDatesAndGuests(checkInDateTime, checkOutDateTime, guests);
    }
}
