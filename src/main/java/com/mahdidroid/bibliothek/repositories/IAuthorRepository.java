package com.mahdidroid.bibliothek.repositories;

import com.mahdidroid.bibliothek.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorRepository extends CrudRepository<Author,Long> {
}
