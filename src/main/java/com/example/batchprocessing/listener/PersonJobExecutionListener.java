package com.example.batchprocessing.listener;

import com.example.batchprocessing.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonJobExecutionListener implements JobExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(PersonJobExecutionListener.class);
    private final JdbcTemplate jdbcTemplate;

    public PersonJobExecutionListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        // do something after job execution

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("Job execution was completed");
            jdbcTemplate.query("SELECT first_name, last_name FROM people",
                            (rs, rowNum) -> new Person(
                                    rs.getString(1),
                                    rs.getString(2)))
                    .forEach(person -> logger.info("Found <{}> in database", person));

        }
    }
}
