package com.example.springboottest.controller;

import com.example.springboottest.domain.Book;
import com.example.springboottest.service.BookRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sskim on 2022/03/19
 * Github : http://github.com/sskim91
 */
@RestController
public class BookRestController {
    @Autowired
    private BookRestService bookRestService;

    @GetMapping(path = "/rest/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getRestBooks() {
        return bookRestService.getRestBook();
    }
}
