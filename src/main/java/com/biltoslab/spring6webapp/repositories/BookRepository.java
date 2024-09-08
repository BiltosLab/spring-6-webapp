package com.biltoslab.spring6webapp.repositories;

import com.biltoslab.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
