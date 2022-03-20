package com.example.batch.jobs;

import com.example.batch.domain.User;
import com.example.batch.domain.enums.UserStatus;
import com.example.batch.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sskim on 2022/03/20
 * Github : http://github.com/sskim91
 */
@Component
@AllArgsConstructor
public class InactiveItemTasklet implements Tasklet {

    private UserRepository userRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        //reader
        Date nowDate = (Date) chunkContext.getStepContext().getJobParameters().get("nowDate");
        LocalDateTime now = LocalDateTime.ofInstant(nowDate.toInstant(), ZoneId.systemDefault());
        List<User> inactiveUsers = userRepository.findByUpdatedDateBeforeAndStatusEquals(now.minusYears(1), UserStatus.ACTIVE);

        //processor
        inactiveUsers = inactiveUsers.stream()
                .map(User::setInactive)
                .collect(Collectors.toList());

        //writer
        userRepository.saveAll(inactiveUsers);

        return RepeatStatus.FINISHED;
    }
}
