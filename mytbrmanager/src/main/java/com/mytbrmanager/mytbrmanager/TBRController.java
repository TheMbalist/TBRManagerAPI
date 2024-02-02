package com.mytbrmanager.mytbrmanager;

import org.springframework.web.bind.annotation.RestController;

import com.mytbrmanager.mytbrmanager.Entites.BooksRead;
import com.mytbrmanager.mytbrmanager.Entites.CurrentlyReading;
import com.mytbrmanager.mytbrmanager.Entites.TBR;
import com.mytbrmanager.mytbrmanager.Repositories.BooksReadRepository;
import com.mytbrmanager.mytbrmanager.Repositories.CurrentlyReadingRepository;
import com.mytbrmanager.mytbrmanager.Repositories.TBRRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("tbr/")
public class TBRController {
    //http://localhost:8080/h2-console
    private final TBRRepository bookRepository;
    private final CurrentlyReadingRepository currentlyReadingRepository;
    private final BooksReadRepository booksReadRepository;

    public TBRController(TBRRepository bookRepository, CurrentlyReadingRepository currentlyReadingRepository, BooksReadRepository booksReadRepository){
        this.bookRepository = bookRepository;
        this.currentlyReadingRepository = currentlyReadingRepository;
        this.booksReadRepository = booksReadRepository;
    }


    /*Read Methods*/

    //TBR class
    @GetMapping("books")
    public Iterable<TBR> getAllBooks() {
       return this.bookRepository.findAll();
    }
    
    @GetMapping("books/author")
    public Iterable<TBR> getBooksByAuthor(@RequestParam(name= "Author", required = false) String author) {
       return this.bookRepository.findByAuthor(author);
    }
    

    @GetMapping("books/title")
    public Iterable<TBR> getBooksByTitle(@RequestParam(name= "Title", required = false) String title) {
       return this.bookRepository.findByTitle(title);
    }
    
    //Books Read
    @GetMapping("booksRead")
    public Iterable<BooksRead> getBooksRead() {
        return this.booksReadRepository.findAll();
    }

    @GetMapping("booksRead/rating?Rating={rating}")
    public Iterable<BooksRead> getBooksReadByRating(@RequestParam(name="Rating", required = false) Integer rating) {
        return this.booksReadRepository.findByRating(rating);
    }
    
    //localhost:8080/tbr/booksRead/dateFinished?Date_Finished=2023-12-23&Rating=5

    @GetMapping("booksRead/rating/lessThan?Rating={rating}")
    public Iterable<BooksRead> getBooksReadByRatingLessThan(@RequestParam(name="Rating", required = false) Integer rating) {
        return this.booksReadRepository.findByRatingGreaterThan(rating);
    }

    @GetMapping("booksRead/dateFinished/lessThan?Date_Finished={dateFinished}")
    public Iterable<BooksRead> getBooksReadByFinishedDateLessThan(@RequestParam(name="Date_Finished", required = false) LocalDate dateFinished) {
        return this.booksReadRepository.findByDateFinishedLessThan(dateFinished);
    }

    @GetMapping("booksRead/dateFinished/greaterThan?Date_Finished={dateFinished}")
    public Iterable<BooksRead> getBooksReadByFinishedDateGreaterThan(@RequestParam(name="Date_Finished", required = false) LocalDate dateFinished) {
        return this.booksReadRepository.findByDateFinishedGreaterThan(dateFinished);
    }

    @GetMapping("booksRead/dateFinished?Date_Finished={dateFinished}")
    public Iterable<BooksRead> getBooksReadByFinishedDate(@RequestParam(name="Date_Finished", required = false) LocalDate dateFinished) {
        return this.booksReadRepository.findByDateFinished(dateFinished);
    }
    //http://localhost:8080/tbr/booksRead/dateFinished?Date_Finished=2023-09-25

    @GetMapping("booksRead/dateFinished?ratingLessThan={rating}")
    public Iterable<BooksRead> getBooksReadByFinishedDateAndRatingLessThan(@RequestParam(name="Rating", required = false) Integer rating, @RequestParam(name="Date_Finished", required = false) LocalDate dateFinished) {
        return this.booksReadRepository.findByDateFinishedAndRatingLessThan(dateFinished, rating);
    }
    
    @GetMapping("booksRead/dateFinished?Date_Finished={dateFinished}&ratingGreaterThan?Rating={rating}")
    public Iterable<BooksRead> getBooksReadByFinishedDateAndRatingGreaterThan(@RequestParam(name="Rating", required = false) Integer rating, @RequestParam(name="Date_Finished", required = false) LocalDate dateFinished) {
        return this.booksReadRepository.findByDateFinishedAndRatingGreaterThan(dateFinished, rating);
    }
    
//http://localhost:8080/tbr/booksRead/dateFinished?Date_Finished=2023-12-23&Rating=5
    
    //Currently Reading
    @GetMapping("currentlyReading")
    public Iterable<CurrentlyReading> getCurrentlyReading() {
        return this.currentlyReadingRepository.findAll();
    }
    
    @GetMapping("currentlyReading/date?Date_Added={dateAdded}")
    public Iterable<CurrentlyReading> getCurrentlyReadingByDateAdded(@RequestParam (name="Date_Added", required = false) LocalDate dateAdded) {
        return this.currentlyReadingRepository.findByDateAdded(dateAdded);
    }
    





    // @GetMapping("greeting")
    // public String HelloWorld() {
    //     return "Hello World";
    // }
    
}
