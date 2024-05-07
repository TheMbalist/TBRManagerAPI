package com.mytbrmanager.mytbrmanager.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytbrmanager.mytbrmanager.Entites.TBR;
import java.util.List;


@Repository
public interface TBRRepository extends CrudRepository<TBR, Long>{
    
   
    List<TBR> findByAuthor(String author);
    List<TBR> findByTitle(String title);
    ;
}
