package com.example.bookmymovie.beans;

import com.example.bookmymovie.persist.entity.MovieSlotEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ShowDetails {
    private Long movieSlotId;
    private LocalTime start;
    private LocalTime end;
    private Double price;

    public ShowDetails(MovieSlotEntity slotEntity) {
        this.movieSlotId = slotEntity.getId();
        this.start = slotEntity.getStartTime();
        this.end = slotEntity.getEndTime();
        this.price = slotEntity.getPrice();
    }
}

