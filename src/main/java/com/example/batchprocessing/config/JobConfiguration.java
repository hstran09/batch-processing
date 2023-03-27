package com.example.batchprocessing.config;

import com.example.batchprocessing.listener.PersonJobExecutionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    @Bean
    public Job importUserJob(JobRepository jobRepository, PersonJobExecutionListener listener, Step upperCaseStep) {
        return new JobBuilder("importUserJob", jobRepository)
//                .incrementer(new RunIdIncrementer()) // be used as Job parameter
                .listener(listener)
                .flow(upperCaseStep).end()
                .build();
    }
}
