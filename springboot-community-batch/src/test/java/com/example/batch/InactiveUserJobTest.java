package com.example.batch;

import com.example.batch.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;

import static com.example.batch.domain.enums.UserStatus.ACTIVE;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by sskim on 2022/03/20
 * Github : http://github.com/sskim91
 */
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class InactiveUserJobTest {
    @Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void 휴면_회원_전환_테스트() throws Exception {
		Date nowDate = new Date();
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(new JobParametersBuilder().addDate("nowDate", nowDate).toJobParameters());

		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
		assertEquals(11, userRepository.findAll().size());
		assertEquals(0, userRepository.findByUpdatedDateBeforeAndStatusEquals(LocalDateTime.now().minusYears(1), ACTIVE).size());
	}
}
