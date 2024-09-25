package com.kh.upload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mapper") // MyBatis가 Mapper를 스캔할 수 있도록 설정
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
