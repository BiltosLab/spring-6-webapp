package com.biltoslab.spring6webapp.services;

import com.biltoslab.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> FindAll();
}
