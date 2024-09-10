package com.biltoslab.spring6webapp.services;

import com.biltoslab.spring6webapp.domain.Book;
import com.biltoslab.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;




@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> FindAll() {
        return bookRepository.findAll();
    }
}
