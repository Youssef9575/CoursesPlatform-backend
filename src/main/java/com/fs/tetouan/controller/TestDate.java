package com.fs.tetouan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class TestDate {

	public static void main(String[] args) {
//		2020-03-03 00:00:00
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		System.out.println(simpleDateFormat.format(new Date()));
		
		Date newDate = DateUtils.addMonths(new Date(), 1);
		
		System.out.println(simpleDateFormat.format(newDate));

	}

}
