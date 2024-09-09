package com.reservation.api.repository;

import com.reservation.api.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT r FROM Room r WHERE r.id NOT IN " +
            "(SELECT res.room.id FROM Reservation res WHERE " +
            "res.checkIn <= :checkOut AND res.checkOut >= :checkIn) " +
            "AND r.maxGuests >= :guests")
    List<Room> findAvailableRoomsBetweenDatesAndGuests(LocalDateTime checkIn, LocalDateTime checkOut, int guests);

}
