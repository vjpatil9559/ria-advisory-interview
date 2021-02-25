package com.interview.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.demo.entity.Employee;
import com.interview.demo.exception.DataNotFoundException;
import com.interview.demo.model.EmployeeVO;
import com.interview.demo.repository.EmployeeRepository;
import com.interview.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeVO> getEmployees() throws DataNotFoundException {
		List<EmployeeVO> employees = new ArrayList<>();
		List<Employee> employeeList = employeeRepository.findAll();
		if (employeeList.isEmpty()) {
			throw new DataNotFoundException("Employees Data Not Available");
		} else {
			LOGGER.info("Employee data found : {}", employeeList.size());
			for (Employee employee : employeeList) {
				LOGGER.info("Finding the manager data for employee : {}", employee);
				EmployeeVO employeeVO = new EmployeeVO();
				employeeVO.setEmployeeName(employee.getEmployeeName());
				List<String> managerHierarchy = new ArrayList<>();
				String[] managerName = { employee.getManagerName() };
				managerHierarchy.add(managerName[0]);
				while (managerName[0] != null) {
					Optional<Employee> empOptional = employeeList.stream()
							.filter(emp -> emp.getEmployeeName().equals(managerName[0])).findFirst();
					if (empOptional.isPresent()) {
						managerName[0] = empOptional.get().getManagerName();
						if (managerName[0] != null) {
							managerHierarchy.add(managerName[0]);
						}
					} else {
						break;
					}
				}
				employeeVO.setManagerHierarchy(managerHierarchy);
				employees.add(employeeVO);
				LOGGER.info("Added the manager data for employee {} found is : {} ", employee, managerHierarchy);
			}
		}
		return employees;
	}

}
