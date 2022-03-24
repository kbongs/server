package com.kh.el.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
//@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String name;
	
	private int age;
	
	private char gender;
}
