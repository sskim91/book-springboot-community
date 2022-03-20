package com.example.springbootweb.repository;

import com.example.springbootweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sskim on 2022/03/20
 * Github : http://github.com/sskim91
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
