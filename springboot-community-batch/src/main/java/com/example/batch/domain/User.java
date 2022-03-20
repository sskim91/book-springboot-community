package com.example.batch.domain;

import com.example.batch.domain.enums.Grade;
import com.example.batch.domain.enums.SocialType;
import com.example.batch.domain.enums.UserStatus;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by sskim on 2022/03/20
 * Github : http://github.com/sskim91
 */
@Getter
@EqualsAndHashCode(of = {"idx", "email"})
@NoArgsConstructor
@Entity
@Table
public class User {
    @Id
    @Column
    @GeneratedValue
    private Long idx;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String pincipal;

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder
    public User(String name, String password, String email, String pincipal, SocialType socialType, UserStatus status, Grade grade, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.pincipal = pincipal;
        this.socialType = socialType;
        this.status = status;
        this.grade = grade;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public User setInactive() {
        status = UserStatus.INACTIVE;
        return this;
    }
}
