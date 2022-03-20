package com.example.springbootweb.domain.enums;

/**
 * Created by sskim on 2022/03/20
 * Github : http://github.com/sskim91
 */
public enum BoardType {
    notice("공지사항"),
    free("자유게시판");

    private String value;

    BoardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
