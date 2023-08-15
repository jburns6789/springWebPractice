package practice.springWebPractice.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    //JPA mapping many authors to many books

    private Set<Book> books;
    //Java mapping
    //you want to use a set, you could use a list but a list allows for duplicate elements, set is preferred

    public java.util.Set<Book> getBooks() {
        return books;
    }

    public void setBooks(java.util.Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
