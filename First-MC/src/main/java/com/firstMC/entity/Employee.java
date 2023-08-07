package com.firstMC.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Employee {

	private int eid;
	
	private String eName;
	
	private String Location;
	
	private int age;
}
