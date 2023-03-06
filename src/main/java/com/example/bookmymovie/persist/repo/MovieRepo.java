package com.example.bookmymovie.persist.repo;

import com.example.bookmymovie.persist.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Long> {
}
