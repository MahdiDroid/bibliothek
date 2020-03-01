package com.mahdidroid.bibliothek.repositories;

import com.mahdidroid.bibliothek.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepository extends CrudRepository<Book,Long> {
}
