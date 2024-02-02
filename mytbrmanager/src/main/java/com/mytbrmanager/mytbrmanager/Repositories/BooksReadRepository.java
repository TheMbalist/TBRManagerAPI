package com.mytbrmanager.mytbrmanager.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytbrmanager.mytbrmanager.Entites.BooksRead;
import com.mytbrmanager.mytbrmanager.Entites.TBR;

import java.util.List;
import java.time.LocalDate;



@Repository
public interface BooksReadRepository extends CrudRepository<BooksRead, Long>{
    
    List<BooksRead> findByBook(TBR book);
    List<BooksRead> findByRating(int rating);
    List<BooksRead> findByDate_finished(LocalDate date_finished);
}
