package com.example.bookmymovie.persist.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String createdBy;
    protected LocalDateTime createdOn;
    protected String updatedBy;
    protected LocalDateTime updatedOn;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
        //TODO Need to get the logged in user
        this.createdBy = "Unresolved";
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedOn = LocalDateTime.now();
        this.updatedBy = "Unresolved";
    }

}