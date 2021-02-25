package com.interview.demo.model;

import java.util.List;

public class EmployeeVO {

	private String employeeName;

	private List<String> managerHierarchy;

	public EmployeeVO() {
		super();
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public List<String> getManagerHierarchy() {
		return managerHierarchy;
	}

	public void setManagerHierarchy(List<String> managerHierarchy) {
		this.managerHierarchy = managerHierarchy;
	}

}
