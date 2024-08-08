package com.kh.ajax.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @NoArgsConstructor @AllArgsConstructor	// application.properties -> lombok 코드 추가
public class Member {
	
	private String id;
	private String password;
	private String name;
}
