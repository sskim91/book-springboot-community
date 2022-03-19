package com.example.springboottest.service;

import com.example.springboottest.domain.Book;

import java.util.List;

/**
 * Created by sskim on 2022/03/19
 * Github : http://github.com/sskim91
 */
public interface BookService {
    List<Book> getBookList();
}
