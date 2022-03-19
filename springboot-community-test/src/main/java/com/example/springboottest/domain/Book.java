package com.example.springboottest.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by sskim on 2022/03/19
 * Github : http://github.com/sskim91
 */
@NoArgsConstructor
@Getter
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue
    private Integer idx;

    @Column
    private String title;

    @Column
    private LocalDateTime publishedAt;

    @Builder
    public Book(String title, LocalDateTime publishedAt) {
        this.title = title;
        this.publishedAt = publishedAt;
    }
}
