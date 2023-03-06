package com.example.bookmymovie.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@AllArgsConstructor
@Data
public class MovieDetails {
    private Long movieSlotId;
    private LocalTime start;
    private LocalTime end;
    private Double price;
}