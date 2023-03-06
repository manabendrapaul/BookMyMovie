package com.example.bookmymovie.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class BookingEntity extends BaseEntity {

    private String customerMobile;
    private String customerEmail;
    private Long movieSlotId;
    private LocalDateTime bookedAt;

}
