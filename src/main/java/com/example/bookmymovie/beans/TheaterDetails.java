package com.example.bookmymovie.beans;

import com.example.bookmymovie.persist.entity.TheatreEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDetails {

    private String theaterName;
    private String city;
    private String country;
    private Set<ShowInfo> showInfos;

    public TheaterDetails(TheatreEntity entity) {
        this.theaterName = entity.getName();
        this.city = entity.getCity();
        this.country = entity.getCountry();
    }
}
