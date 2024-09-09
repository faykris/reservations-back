package com.reservation.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomDto {
    private int id;
    private String name;
    private String description;
    private String urlImage;
    private BigDecimal price;
    private int maxGuests;
}
