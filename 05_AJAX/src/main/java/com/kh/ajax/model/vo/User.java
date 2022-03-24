package com.kh.ajax.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int no;
	
	private String name;
	
	private int age;
	
	private char gender;
}
