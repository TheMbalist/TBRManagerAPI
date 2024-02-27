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
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





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
    
    @GetMapping("books/author?Author={author}")
    public Iterable<TBR> getBooksByAuthor(@RequestParam(name= "Author", required = false) String author) {
       return this.bookRepository.findByAuthor(author);
    }
    

    @GetMapping("books/title?Title={title}")
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
    
    /*Post Mappings */
    //TBR
    @PostMapping("addBooks")
    public TBR createBooks(@RequestBody TBR book) {
        TBR newBook = this.bookRepository.save(book);     
        return newBook;
    }
    
    //CurrentlyReading
    @PostMapping("addToCurrentlyReading")
    public CurrentlyReading createCurrentlyReading(@RequestBody CurrentlyReading currentlyReading) {
        CurrentlyReading currentlyReadingBook = this.currentlyReadingRepository.save(currentlyReading);     
        return currentlyReadingBook;
    }

    //Books Read
    @PostMapping("addToBooksRead")
    public BooksRead createBooksRead(@RequestBody BooksRead bookRead) {
        BooksRead bookFininshedReadng = this.booksReadRepository.save(bookRead);     
        return bookFininshedReadng;
    }

    

    /*Put Mappings */
    //Book List
    @PutMapping("books/{id}")
    public TBR updateBooks(@PathVariable("id")Long id, @RequestBody TBR book) {

        Optional<TBR> bookToUpdateOptional = this.bookRepository.findById(id);
        if(!bookToUpdateOptional.isPresent()){
            return null;};

        TBR bookToUpdate = bookToUpdateOptional.get();

        if(book.getAuthor() != null){
            bookToUpdate.setAuthor(book.getAuthor());
        }

        if(book.getTitle() != null){
            bookToUpdate.setTitle(book.getTitle());
        }

        TBR updatedBook = this.bookRepository.save(bookToUpdate);

        return updatedBook;
    }

    //Currently Reading
    @PutMapping("currentlyReading/{id}")
    public CurrentlyReading updatCurrentlyReading(@PathVariable ("id") Long id, @RequestBody CurrentlyReading bookCurrentlyReading,  @RequestBody TBR book) {
        Optional<CurrentlyReading> currentlyReadingOptional = this.currentlyReadingRepository.findById(id);

        if(!currentlyReadingOptional.isPresent()){
            return null;
        }
       

        CurrentlyReading currentlyReadingToUpdate = currentlyReadingOptional.get();

        if(bookCurrentlyReading.getDate_added() != null){
            currentlyReadingToUpdate.setDate_added(bookCurrentlyReading.getDate_added());
        }

        if (bookCurrentlyReading.getBookid().getID() != null) {
            currentlyReadingToUpdate.setBookid(bookCurrentlyReading.getBookid());
        }

        CurrentlyReading updatedCurrentlyReading = this.currentlyReadingRepository.save(currentlyReadingToUpdate);
        
        return updatedCurrentlyReading;
    }

    //Book Read
    @PutMapping("booksRead/{id}")
    public BooksRead updateBooksRead(@PathVariable ("id") Long id, @RequestBody BooksRead bookRead) {
        Optional<BooksRead> booksReadOptional = this.booksReadRepository.findById(id);
        if(!booksReadOptional.isPresent()){
            return null;
        }

        BooksRead bookReadToUpdate = booksReadOptional.get();

        if(bookRead.getBook().getID() != null){
            bookReadToUpdate.setBook(bookRead.getBook());
        }

        if(bookRead.getDate_finished() != null){
            bookReadToUpdate.setDate_finished(bookRead.getDate_finished());
        }

        if(bookRead.getRating() != null){
            bookReadToUpdate.setRating(bookRead.getRating());
        }

        BooksRead updatedBookRead = this.booksReadRepository.save(bookReadToUpdate);
        
        return updatedBookRead;
    }

    /*Delete Mappings */
    @DeleteMapping("/books/delete/{id}")
    public TBR deleteBooks(@PathVariable("id") Long id){

        Optional<TBR> bookToDeleteOptional = this.bookRepository.findById(id);
        if(!bookToDeleteOptional.isPresent()){
            return null;
        }

        TBR bookToDelete = bookToDeleteOptional.get();
        this.bookRepository.delete(bookToDelete);

        return bookToDelete;
    }

    @DeleteMapping("/currentlyReading/delete/{id}")
    public CurrentlyReading deleteCurrentlyReadingBooks(@PathVariable("id") Long id){

        Optional<CurrentlyReading> bookToDeleteOptional = this.currentlyReadingRepository.findById(id);
        if(!bookToDeleteOptional.isPresent()){
            return null;
        }

        CurrentlyReading bookToDelete = bookToDeleteOptional.get();
        this.currentlyReadingRepository.delete(bookToDelete);

        return bookToDelete;
    }

    @DeleteMapping("/booksRead/delete/{id}")
    public BooksRead deleteReadBooks(@PathVariable("id") Long id){

        Optional<BooksRead> bookToDeleteOptional = this.booksReadRepository.findById(id);
        if(!bookToDeleteOptional.isPresent()){
            return null;
        }

        BooksRead bookToDelete = bookToDeleteOptional.get();
        this.booksReadRepository.delete(bookToDelete);

        return bookToDelete;
    }



    // @GetMapping("greeting")
    // public String HelloWorld() {
    //     return "Hello World";
    // }
    
}
