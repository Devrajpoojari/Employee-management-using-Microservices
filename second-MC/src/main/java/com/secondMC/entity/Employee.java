package com.secondMC.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

// this is not an entity 
public class Employee {

	private int eid;

	private String eName;

	private String Location;

	private int age;
}
