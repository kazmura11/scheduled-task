package com.example.scheduledtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.scheduledtask.util.ReflectionUtil;

@SpringBootApplication
public class ScheduledTaskApplication implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTaskApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ScheduledTaskApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("{} invoked.", ReflectionUtil.getClassAndMethodName());
	}

}

