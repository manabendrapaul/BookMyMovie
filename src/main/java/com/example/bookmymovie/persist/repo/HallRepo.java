package com.example.bookmymovie.persist.repo;

import com.example.bookmymovie.persist.entity.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepo extends JpaRepository<HallEntity, Long> {
}
