package com.example.springboottest.repository;

import com.example.springboottest.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sskim on 2022/03/19
 * Github : http://github.com/sskim91
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
