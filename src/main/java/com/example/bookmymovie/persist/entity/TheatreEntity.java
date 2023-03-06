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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "theater")
@Getter
@Setter
public class TheatreEntity extends BaseEntity {

    private String name;
    private String city;
    private String country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<HallEntity> halls;
    @ManyToMany
    @JoinTable(
            name = "theater_movie",
            joinColumns = @JoinColumn(name = "theater_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<MovieEntity> movies;

}
