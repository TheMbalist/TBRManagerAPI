package com.mytbrmanager.mytbrmanager.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytbrmanager.mytbrmanager.Entites.BooksRead;
import com.mytbrmanager.mytbrmanager.Entites.TBR;

import java.util.List;
import java.time.LocalDate;



@Repository
public interface BooksReadRepository extends CrudRepository<BooksRead, Long>{
    
    List<BooksRead> findByBook(TBR BOOKID);
    List<BooksRead> findByRating(Integer rating);
    List<BooksRead> findByRatingGreaterThan(Integer rating);
    List<BooksRead> findByRatingLessThan(Integer rating);
    List<BooksRead> findByDateFinishedAndRatingGreaterThan(LocalDate date_finished,Integer rating);
    List<BooksRead> findByDateFinishedAndRatingLessThan(LocalDate date_finished,Integer rating);
    List<BooksRead> findByDateFinished(LocalDate date_finished);
    List<BooksRead> findByDateFinishedLessThan(LocalDate date_finished);
    List<BooksRead> findByDateFinishedGreaterThan(LocalDate date_finished);
}
