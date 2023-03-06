package com.example.bookmymovie.persist.repo;

import com.example.bookmymovie.persist.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends JpaRepository<SeatEntity, Long> {
}
