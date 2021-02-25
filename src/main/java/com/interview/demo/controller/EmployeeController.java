package com.interview.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.exception.DataNotFoundException;
import com.interview.demo.model.EmployeeVO;
import com.interview.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/employee")
	public List<EmployeeVO> getEmployees() throws DataNotFoundException {
		LOGGER.info("Request received to get employee and their manager's info");
		return employeeService.getEmployees();
	}

}
