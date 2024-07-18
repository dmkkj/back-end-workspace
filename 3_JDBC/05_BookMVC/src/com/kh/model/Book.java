package com.kh.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @NoArgsConstructor
@AllArgsConstructor
public class Book {

	private int bookNo;
	private String bookTitle;
	private String bookAuthor;
	private int bookPrice;
	private int bookPubNo;
}
