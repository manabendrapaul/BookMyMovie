package com.example.bookmymovie.service;

import com.example.bookmymovie.beans.ShowDetails;
import com.example.bookmymovie.beans.ShowInfo;
import com.example.bookmymovie.beans.TheaterDetails;
import com.example.bookmymovie.persist.entity.HallEntity;
import com.example.bookmymovie.persist.entity.MovieSlotEntity;
import com.example.bookmymovie.persist.entity.TheatreEntity;
import com.example.bookmymovie.persist.repo.BookingRepo;
import com.example.bookmymovie.persist.repo.HallRepo;
import com.example.bookmymovie.persist.repo.MovieRepo;
import com.example.bookmymovie.persist.repo.MovieSlotRepo;
import com.example.bookmymovie.persist.repo.SeatRepo;
import com.example.bookmymovie.persist.repo.TheaterRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class B2CService {

    private final TheaterRepo theaterRepo;
    private final MovieRepo movieRepo;
    private final SeatRepo seatRepo;
    private final HallRepo hallRepo;
    private final BookingRepo bookingRepo;
    private final MovieSlotRepo movieSlotRepo;

    public Set<TheaterDetails> getCurrentlyShowingMoviesByTheater(String country, String city) {
        List<TheatreEntity> theaters = theaterRepo.findByCityAndCountry(city, country);
        Map<TheatreEntity, List<MovieSlotEntity>> movieSlots = theaters.stream()
                .map(TheatreEntity::getHalls)
                .flatMap(Collection::stream)
                .map(HallEntity::getMovieSlots)
                .flatMap(Collection::stream)
                .filter(MovieSlotEntity::getCurrentlyShowing)
                .collect(Collectors.groupingBy(p -> p.getHall().getTheater()));
        return movieSlots.entrySet().stream().map(e -> {
            TheaterDetails theaterDetails = new TheaterDetails(e.getKey());
            Set<ShowInfo> showInfo = e.getValue().stream().collect(Collectors.groupingBy(p -> p.getMovie().getName(),
                    Collectors.mapping(ShowDetails::new, Collectors.toSet()))).entrySet().stream().map(entry -> new ShowInfo(entry.getKey(), entry.getValue())).collect(Collectors.toSet());
            theaterDetails.setShowInfos(showInfo);
            return theaterDetails;
        }).collect(Collectors.toSet());
    }



}
