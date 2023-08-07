package com.firstMC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstMC.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	List<Employee> list = new ArrayList<>();

	// get employee
	@GetMapping("/getEmployeeDetails/{eid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int eid) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEid() == eid) {
				return new ResponseEntity<>(list.get(i), HttpStatus.OK);
			}

		}
		throw new Exception("Employee Details not Exists with id : " + eid);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Employee employee) {
		list.add(employee);
		return ResponseEntity.ok(employee);
	}

	@GetMapping("/get-all")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(list);
	}

}
