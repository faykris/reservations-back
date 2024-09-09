package com.reservation.api.service;

import com.reservation.api.dto.RoomDto;
import com.reservation.api.models.Room;

import java.util.List;

public interface RoomService {
    RoomDto createRoom(RoomDto roomDto);
    List<Room> getRooms();
    Room getRoomById(int id);
    List<Room> getRoomsBetweenDates(String checkIn, String checkOut, int guests);
}
