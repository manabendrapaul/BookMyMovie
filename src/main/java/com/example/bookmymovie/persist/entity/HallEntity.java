package com.example.bookmymovie.persist.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hall")
@Getter
@Setter
public class HallEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private TheatreEntity theater;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hall", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<SeatEntity> seats;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<MovieSlotEntity> movieSlots;

}
