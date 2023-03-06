package com.example.bookmymovie.persist.repo;

import com.example.bookmymovie.persist.entity.MovieSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieSlotRepo extends JpaRepository<MovieSlotEntity, Long> {

}
