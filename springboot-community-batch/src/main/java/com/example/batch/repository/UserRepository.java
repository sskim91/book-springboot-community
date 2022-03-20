package com.example.batch.repository;

import com.example.batch.domain.User;
import com.example.batch.domain.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by sskim on 2022/03/20
 * Github : http://github.com/sskim91
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUpdatedDateBeforeAndStatusEquals(LocalDateTime localDateTime, UserStatus status);
}
