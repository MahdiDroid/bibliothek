package com.mahdidroid.bibliothek.bootstrap;

import com.mahdidroid.bibliothek.domain.Author;
import com.mahdidroid.bibliothek.domain.Book;
import com.mahdidroid.bibliothek.domain.Publisher;
import com.mahdidroid.bibliothek.repositories.IAuthorRepository;
import com.mahdidroid.bibliothek.repositories.IBookRepository;
import com.mahdidroid.bibliothek.repositories.IPublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final IAuthorRepository authorRepository;
    private  final IBookRepository bookRepository;
    private  final IPublisherRepository publisherRepository ;

    public BootStrapData(IAuthorRepository authorRepository, IBookRepository bookRepository, IPublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher1 = new Publisher("O'Reily","22strasse");
        publisherRepository.save(publisher1);



        Author author1 = new Author("Bob","uncle");
        Book book1 = new Book("Test Driven Design","123456");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);



        Author jessy = new Author("Jessy","lure");
        Book DDD = new Book("Domain driven design ","987654");
        DDD.setPublisher(publisher1);

        jessy.getBooks().add(DDD);
        DDD.getAuthors().add(jessy);
        publisher1.getBooks().add(DDD);



        authorRepository.save(jessy);
        bookRepository.save(DDD);
        publisherRepository.save(publisher1);


        System.out.println("boostrap stared");
        System.out.println("number of books: "+ bookRepository.count());



    }
}
