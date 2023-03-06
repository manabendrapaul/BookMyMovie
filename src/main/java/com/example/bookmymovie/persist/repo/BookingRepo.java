package com.example.bookmymovie.persist.repo;

import com.example.bookmymovie.persist.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<BookingEntity, Long> {
}
