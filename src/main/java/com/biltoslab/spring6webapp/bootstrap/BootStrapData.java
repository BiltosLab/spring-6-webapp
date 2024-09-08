package com.biltoslab.spring6webapp.bootstrap;

import com.biltoslab.spring6webapp.domain.Author;
import com.biltoslab.spring6webapp.domain.Book;
import com.biltoslab.spring6webapp.domain.Publisher;
import com.biltoslab.spring6webapp.repositories.AuthorRepository;
import com.biltoslab.spring6webapp.repositories.BookRepository;
import com.biltoslab.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository , PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher dddpub = new Publisher();
        dddpub.setName("Penguin Books");
        dddpub.setAddress("375 Hudson Street");
        dddpub.setCity("New York");
        dddpub.setState("NY");
        dddpub.setZip("10014");
        Publisher savedpublisher = publisherRepository.save(dddpub);
        publisherRepository.save(savedpublisher);


        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456789");
        ddd.setPublisher(dddpub);

        Author ericsaved = authorRepository.save(eric);
        Book dddsaved = bookRepository.save(ddd);

        Author jake = new Author();
        jake.setFirstName("Jake");
        jake.setLastName("Ford");

        Book Algo = new Book();
        Algo.setTitle("Algorithms Design");
        Algo.setIsbn("987654321");
        Algo.setPublisher(dddpub);

        Author jakesaved = authorRepository.save(jake);
        Book Algosaved = bookRepository.save(Algo);

        ericsaved.getBooks().add(ddd);
        jakesaved.getBooks().add(Algo);

        dddsaved.getAuthors().add(ericsaved);
        Algosaved.getAuthors().add(jakesaved);


        dddpub.setBooks(ericsaved.getBooks());
        dddpub.setBooks(jakesaved.getBooks());


        dddsaved.setPublisher(savedpublisher);
        Algosaved.setPublisher(savedpublisher);

        authorRepository.save(ericsaved);
        authorRepository.save(jakesaved);
        bookRepository.save(dddsaved);
        bookRepository.save(Algosaved);
        System.out.println("In BootStrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
