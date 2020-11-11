package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.EmployeeType;
import com.fleet.project.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;

	// return a list of employeeTypes
	public List<EmployeeType> getEmployeeTypes() {
		return employeeTypeRepository.findAll();
	}

	// Save new EmployeeType
	public void saveEmployeeType(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}

	// Update EmployeeType
	public void updateEmployeeType(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}

	// Update EmployeeType
	public void deleteEmployeeType(int id) {
		employeeTypeRepository.deleteById(id);
	}

	// get by id
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

}
