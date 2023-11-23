package com.example.demo.config;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class scheduler {
	private final Logger schedulerLog = LoggerFactory.getLogger("scheduler_log");
	
	@Scheduled(cron = "10 * * * * *", zone = "Asia/Seoul")
	public void cronJobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		String strDate = sdf.format(now);
		schedulerLog.info("[ ::: 스케줄러 실행 ::: ]"+strDate);
	}
}
