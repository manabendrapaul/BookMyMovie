package com.example.bookmymovie.persist.repo;

import com.example.bookmymovie.persist.entity.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepo extends JpaRepository<TheatreEntity, Long> {
    List<TheatreEntity> findByCityAndCountry(String city, String country);
}
