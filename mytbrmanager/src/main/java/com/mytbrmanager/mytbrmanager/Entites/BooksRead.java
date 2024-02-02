package com.mytbrmanager.mytbrmanager.Entites;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name="TBRManager")
@AllArgsConstructor
public class BooksRead {
    
    public BooksRead(){}


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="BOOKID")
    private TBR book;

    @Column(name="Date_Finished")
    private Date date_finished;

    @Column(name="Rating")
    private Integer rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TBR getBook() {
        return book;
    }

    public void setBook(TBR book) {
        this.book = book;
    }

    public Date getDate_finished() {
        return date_finished;
    }

    public void setDate_finished(Date date_finished) {
        this.date_finished = date_finished;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
}
