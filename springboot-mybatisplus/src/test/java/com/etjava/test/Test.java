package com.etjava.test;

import com.etjava.test.entity.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

	public static void main(String[] args) {
		log.info("lombok 集成的logger日志");
		Student s = new Student();
		s.setId(1);
		s.setName("tom");
		System.out.println(s);
	}
}
