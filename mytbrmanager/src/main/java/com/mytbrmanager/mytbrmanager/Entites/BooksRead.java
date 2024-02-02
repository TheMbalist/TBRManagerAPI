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
@Table(name="BooksRead")
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
    @Temporal(TemporalType.DATE)
    private LocalDate dateFinished;

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

    public LocalDate getDate_finished() {
        return dateFinished;
    }

    public void setDate_finished(LocalDate date_finished) {
        this.dateFinished = date_finished;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
}
