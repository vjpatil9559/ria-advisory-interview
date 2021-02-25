package com.interview.demo.service;

import java.util.List;

import com.interview.demo.exception.DataNotFoundException;
import com.interview.demo.model.EmployeeVO;

public interface EmployeeService {

	public List<EmployeeVO> getEmployees() throws DataNotFoundException;
	
}
