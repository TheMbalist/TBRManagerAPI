package com.mytbrmanager.mytbrmanager.Entites;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;

@Entity
@Table(name="Currently_Reading")
@AllArgsConstructor
public class CurrentlyReading {
    
    public CurrentlyReading(){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="BOOKID")
    private TBR bookid;

     @Column(name="Date_Added")
    @Temporal(TemporalType.DATE) 
    private LocalDate date_added;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate_added() {
        return date_added;
    }

    public void setDate_added(LocalDate date_added) {
        this.date_added = date_added;
    }

}
