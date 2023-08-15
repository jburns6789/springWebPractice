package practice.springWebPractice.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import practice.springWebPractice.domain.Author;
import practice.springWebPractice.domain.Book;
import practice.springWebPractice.domain.Publisher;
import practice.springWebPractice.repositories.AuthorRepository;
import practice.springWebPractice.repositories.BookRepository;
import practice.springWebPractice.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Publisher pub1 = new Publisher();
        pub1.setPubName("Clearing House");
        pub1.setCity("Akron");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved =  bookRepository.save(ddd);
        Publisher pub1Saved = publisherRepository.save(pub1);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Stephens");

        Book bse = new Book();
        bse.setTitle("Beginning Software Engineering");
        bse.setIsbn("789456");

        Publisher pub2 = new Publisher();
        pub2.setPubName("Pearson");
        pub2.setCity("Cleveland");

        Author rodSaved = authorRepository.save(rod);
        Book bseSaved = bookRepository.save(bse);
        Publisher pub2Saved = publisherRepository.save(pub2);

        dddSaved.setPublisher(pub1Saved);
        bseSaved.setPublisher(pub2Saved);

        //creating association:
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(bseSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(bseSaved);
        //persisted the book relationship



        System.out.println("In bootstrap");
        System.out.println("Author Count:" + authorRepository.count());
        System.out.println("Book Count:" + bookRepository.count());
        System.out.println("Publisher Count:" + publisherRepository.count());

    }
    //this is how a method is implemented for spring to detect and the method to be executed
}
