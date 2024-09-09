package com.reservation.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReservationDto {
    private int id;
    private int userId;
    private int roomId;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private LocalDateTime createdAt;
    private String status;
    private BigDecimal totalPrice;
}
