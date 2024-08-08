package com.kh.ajax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mapper") // "mapper" 패키지 안에 있는 ..
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
