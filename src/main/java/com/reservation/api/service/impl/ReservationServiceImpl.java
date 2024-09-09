package com.reservation.api.service.impl;

import com.reservation.api.dto.ReservationDto;
import com.reservation.api.models.Reservation;
import com.reservation.api.models.Room;
import com.reservation.api.models.UserEntity;
import com.reservation.api.repository.ReservationRepository;
import com.reservation.api.repository.RoomRepository;
import com.reservation.api.repository.UserRepository;
import com.reservation.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  RoomRepository roomRepository,
                                  UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ReservationDto createReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        Room room = roomRepository.findById(reservationDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        UserEntity user = userRepository.findById(reservationDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        reservation.setRoom(room);
        reservation.setUser(user);
        reservation.setCheckIn(reservationDto.getCheckIn());
        reservation.setCheckOut(reservationDto.getCheckOut());
        reservation.setStatus(reservationDto.getStatus());
        reservation.setCreatedAt(reservationDto.getCreatedAt());
        reservation.setTotalPrice(reservationDto.getTotalPrice());

        Reservation newReservation = reservationRepository.save(reservation);

        ReservationDto reservationResponse = new ReservationDto();

        reservationResponse.setId(newReservation.getId());
        reservationResponse.setUserId(newReservation.getUser().getId());
        reservationResponse.setRoomId(newReservation.getRoom().getId());
        reservationResponse.setCheckIn(newReservation.getCheckIn());
        reservationResponse.setCheckOut(newReservation.getCheckOut());
        reservationResponse.setStatus(newReservation.getStatus());
        reservationResponse.setCreatedAt(newReservation.getCreatedAt());
        reservationResponse.setTotalPrice(newReservation.getTotalPrice());


        return reservationResponse;
    }

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id " + id));
    }

    @Override
    public ReservationDto updateReservation(ReservationDto reservationDto, int reservationId) {
        Reservation existingReservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id " + reservationId));

        Room room = roomRepository.findById(reservationDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        UserEntity user = userRepository.findById(reservationDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingReservation.setCheckIn(reservationDto.getCheckIn());
        existingReservation.setCheckOut(reservationDto.getCheckOut());
        existingReservation.setStatus(reservationDto.getStatus());
        existingReservation.setRoom(room);
        existingReservation.setUser(user);
        existingReservation.setTotalPrice(reservationDto.getTotalPrice());

        Reservation newReservation = reservationRepository.save(existingReservation);
        ReservationDto reservationResponse = new ReservationDto();

        reservationResponse.setId(newReservation.getId());
        reservationResponse.setUserId(newReservation.getUser().getId());
        reservationResponse.setRoomId(newReservation.getRoom().getId());
        reservationResponse.setCheckIn(newReservation.getCheckIn());
        reservationResponse.setCheckOut(newReservation.getCheckOut());
        reservationResponse.setStatus(newReservation.getStatus());
        reservationResponse.setTotalPrice(newReservation.getTotalPrice());

        return reservationResponse;
    }

    @Override
    public List<Reservation> getReservationsByUserId(int userId) {
        return reservationRepository.findByUserId(userId);
    }
}
