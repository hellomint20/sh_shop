package com.example.demo.config;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class scheduler {
	
	@Scheduled(cron = "0 * * * * *", zone = "Asia/Seoul")
	public void cronJobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		String strDate = sdf.format(now);
		System.out.println("[ ::: 스케줄러 실행 ::: ]"+strDate);
	}
}
