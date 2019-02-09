package com.example.scheduledtask.tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.scheduledtask.util.ReflectionUtil;

@Component
public class FutureTask implements Callable<Boolean> {
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

	@Override
	public Boolean call() throws Exception {
		logger.info("{} start.", ReflectionUtil.getClassAndMethodName());
		try {
			logger.info("future heavy task processing ...");
			TimeUnit.SECONDS.sleep(10);
			// TODO something...
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		logger.info("{} end.", ReflectionUtil.getClassAndMethodName());
		return true;
	}
}
