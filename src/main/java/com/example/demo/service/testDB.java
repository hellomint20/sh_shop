package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.testDBMapper;

@Service
public class testDB {
	@Autowired
	testDBMapper tm;

	public void insertDB() {
		// 시간 설정
		Date today = new Date();
		Locale currentLocale = new Locale("KOREAN", "KOREA");
		String pattern = "yyyyMMdd HH:mm:ss:SS";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
		String datetime = formatter.format(today);

		Map<String, Object> map = new HashMap<>();
		String text = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 무궁화 삼천리 화려 강산 대한 사람 대한으로 길이 보전하세 남산 위에 저 소나무 철갑을 두른 듯 바람 서리 불변함은 우리 기상일세 무궁화 삼천리 화려 강산 대한 사람 대한으로 길이 보전하세 가을 하늘 공활한데 높고 구름 없이 밝은 달은 우리 가슴 일편단심일세 무궁화 삼천리 화려 강산 대한 사람 대한으로 길이 보전하세";

		int index = 0;
		String contents = "";
		for (int i = 0; i < 21000; i+=1000) {
			contents = text.split("\\s")[index] + " " + text.split("\\s")[index + 1];

			if (i < 1000) {
				map.put("url", "www.naver.com");
				map.put("platform", "네이버");
			} else if (i >= 1000 && i < 3000) {
				map.put("url", "www.daum.net");
				map.put("platform", "다음");
			} else if (i >= 3000 && i < 6000) {
				map.put("url", "www.google.com");
				map.put("platform", "구글");
			} else if (i >= 6000 && i < 9000) {
				map.put("url", "www.kakaocorp.com");
				map.put("platform", "카카오");
			} else if (i >= 9000 && i < 12000) {
				map.put("url", "www.cultureland.co.kr");
				map.put("platform", "컬쳐랜드");
			} else if (i >= 12000 && i < 15000) {
				map.put("url", "www.interpark.comr");
				map.put("platform", "인터파크");
			} else if (i >= 15000 && i < 18000) {
				map.put("url", "www.melon.com");
				map.put("platform", "멜론");
			} else if (i >= 18000 && i < 21000) {
				map.put("url", "www.kyobobook.co.kr");
				map.put("platform", "교보문고");
			}

			for (int j = 1; j < 1000; j++) {

				map.put("contents", contents + j);
				map.put("datetime", datetime);

				tm.insertDB(map);

				try {
					Thread.sleep(100);
					datetime = formatter.format(System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			index += 2;
		}
	}
}
