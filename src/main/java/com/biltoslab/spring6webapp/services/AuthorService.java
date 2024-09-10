package com.biltoslab.spring6webapp.services;

import com.biltoslab.spring6webapp.domain.Author;


public interface AuthorService {
    Iterable<Author> FindAll();
}
