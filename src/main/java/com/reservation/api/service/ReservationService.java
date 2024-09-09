package com.reservation.api.service;

import com.reservation.api.dto.ReservationDto;
import com.reservation.api.models.Reservation;

import java.util.List;

public interface ReservationService {
    ReservationDto createReservation(ReservationDto reservationDto);
    List<Reservation> getReservations();
    Reservation getReservationById(int id);
    ReservationDto updateReservation(ReservationDto reservationDto, int reservationId);
    List<Reservation> getReservationsByUserId(int userId);
}
