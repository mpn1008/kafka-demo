package com.example.kafka_demo.infra.taskexecutor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class TaskExecutorConfig {

  public Executor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(5);           // Minimum number of threads in the pool
    executor.setMaxPoolSize(10);          // Maximum number of threads
    executor.setQueueCapacity(25);        // Size of the task queue
    executor.setThreadNamePrefix("MyTaskExecutor-"); // Custom thread name prefix
    executor.initialize();
    return executor;
  }
}
