package practice.springWebPractice.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import practice.springWebPractice.domain.Author;
import practice.springWebPractice.domain.Book;
import practice.springWebPractice.repositories.AuthorRepository;
import practice.springWebPractice.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved =  bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Stephens");

        Book bse = new Book();
        bse.setTitle("Beginning Software Engineering");
        bse.setIsbn("789456");

        Author rodSaved = authorRepository.save(rod);
        Book bseSaved = bookRepository.save(bse);

        //creating association:
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(bseSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        //persisted the book relationship

        System.out.println("In bootstrap");
        System.out.println("Author Count:" + authorRepository.count());
        System.out.println("Book Count:" + bookRepository.count());

    }
    //this is how a method is implemented for spring to detect and the method to be executed
}
