package com.example.bookmymovie.controller;

import com.example.bookmymovie.beans.ApiResponse;
import com.example.bookmymovie.beans.TheaterDetails;
import com.example.bookmymovie.service.B2CService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/b2c")
@RequiredArgsConstructor
public class B2CController {

    private final B2CService b2CService;

    @GetMapping("/country/{country}/city/{city}/movies")
    public ResponseEntity<ApiResponse<Set<TheaterDetails>>> getMoviesByCityAndCountry(@PathVariable String country, @PathVariable String city) {
        return ResponseEntity.ok(new ApiResponse<>(b2CService.getCurrentlyShowingMoviesByTheater(country, city)));
    }

}
