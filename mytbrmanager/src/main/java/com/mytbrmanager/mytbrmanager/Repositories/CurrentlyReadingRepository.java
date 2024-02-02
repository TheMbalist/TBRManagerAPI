package com.mytbrmanager.mytbrmanager.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytbrmanager.mytbrmanager.Entites.CurrentlyReading;
import java.util.List;
import java.time.LocalDate;


@Repository
public interface CurrentlyReadingRepository extends CrudRepository<CurrentlyReading, Long> {

    List<CurrentlyReading> findByDateAdded(LocalDate date_added);

    
}
