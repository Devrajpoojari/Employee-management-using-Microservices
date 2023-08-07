package com.secondMC.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.secondMC.entity.Department;
import com.secondMC.entity.Employee;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	List<Department> dList = new ArrayList<>();

	@Autowired
	RestTemplate restTemplate;

	final static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

//	@GetMapping("/get-dpt-byemp-id/{eId}")
//	public ResponseEntity<?> getDepartmentByEMpId(@PathVariable int eId) {
//
//	}

	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "fallback")
	@PostMapping("/add-dpt/{eId}")
	public ResponseEntity<?> add(@RequestBody Department department, @PathVariable int eId) {
		Employee emp = restTemplate.getForObject("http://localhost:8081/employee/getEmployeeDetails/" + eId,
				Employee.class);
		logger.info("Getting Employee Details from Employee Microservice ");
		department.setEmployee(emp);
		dList.add(department);
		logger.info("Setting Employee Details from Employee Microservice");
		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	public ResponseEntity<?> fallback(Exception ex) {
		return new ResponseEntity<>("Requested Server is Currently In maintanance", HttpStatus.OK);
	}

}
