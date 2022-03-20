package com.example.batch.jobs;

import com.example.batch.domain.User;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by sskim on 2022/03/20
 * Github : http://github.com/sskim91
 */
public class InactiveItemProcessor implements ItemProcessor<User, User> {
    @Override
    public User process(User user) {
        return user.setInactive();
    }
}
