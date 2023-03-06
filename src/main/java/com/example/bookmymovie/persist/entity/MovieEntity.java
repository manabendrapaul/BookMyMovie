package com.example.bookmymovie.persist.entity;

import com.example.bookmymovie.enums.Genre;
import com.example.bookmymovie.enums.Language;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class MovieEntity extends BaseEntity {

    private String name;
    private Long durationInMinutes;
    private LocalDateTime releasedOn;
    @Enumerated(EnumType.STRING)
    private Language language;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToMany(mappedBy = "movies")
    private List<TheatreEntity> theaters;

}
