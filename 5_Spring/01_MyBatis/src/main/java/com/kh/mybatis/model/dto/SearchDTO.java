package com.kh.mybatis.model.dto;

import lombok.Getter;
import lombok.Setter;

// DTO(Data Transfer Object) : 데이터 전송 객체

@Getter @Setter // 담아내고 보내고 정도만 필요
public class SearchDTO {
	private String keyword;
	private String select;
}
