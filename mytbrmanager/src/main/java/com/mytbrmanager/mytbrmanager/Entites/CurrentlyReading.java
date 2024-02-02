package com.mytbrmanager.mytbrmanager.Entites;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name="Currently_Reading")
@AllArgsConstructor
public class CurrentlyReading {
    
    public CurrentlyReading(){}

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="BOOKID")
    private Date date_added;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

}
