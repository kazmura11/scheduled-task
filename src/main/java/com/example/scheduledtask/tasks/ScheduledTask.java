package com.example.scheduledtask.tasks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.scheduledtask.util.ReflectionUtil;

@EnableScheduling
@Component
public class ScheduledTask {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
	private ExecutorService executorService = Executors.newSingleThreadExecutor();
	private Future<?> future = null;
	@Autowired
	FutureTask futureTask;
	
	/**
	 * 5秒ごとに実行されるTask
	 * Springから自動的に呼び出される
	 * ちなみにメソッドの名前は何でもよい
	 */
	@Scheduled(cron = "0/5 * * * * *")
	public void run() {
		logger.info("{} invoked.", ReflectionUtil.getClassAndMethodName());
		//lightTask();
		//heavyTask();
		heavyTaskWithFuture();
	}
	
	/**
	 * 軽いTask
	 */
	public void lightTask() {
		logger.info("{} start.", ReflectionUtil.getClassAndMethodName());
		logger.info("light task processing ...");
		// TODO something...
		logger.info("{} end.", ReflectionUtil.getClassAndMethodName());
	}

	/**
	 * 重いTask
	 */
	public void heavyTask() {
		logger.info("{} start.", ReflectionUtil.getClassAndMethodName());
		try {
			logger.info("heavy task processing ...");
			TimeUnit.SECONDS.sleep(10);
			// TODO something...
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("{} end.", ReflectionUtil.getClassAndMethodName());
	}
	

	/**
	 * 重いTask (Future利用)
	 */
	public void heavyTaskWithFuture() {
		logger.info("{} start.", ReflectionUtil.getClassAndMethodName());
		if (future == null || future.isDone()) {
			future = executorService.submit(futureTask);  // 別スレッドで実行
		}
		logger.info("{} end.", ReflectionUtil.getClassAndMethodName());
	}
}
