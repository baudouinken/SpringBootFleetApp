package com.fleet.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.project.models.EmployeeType;
import com.fleet.project.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {
	
	@Autowired
	private EmployeeTypeService employeeTypeService;

	@GetMapping("/employeetypes")
	public String getEmployeeTypes(Model model) {

		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
		model.addAttribute("employeeTypes", employeeTypeList);

		return "EmployeeType";
	}

	@GetMapping("/employeeTypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeService.findById(id);

	}

	@PostMapping("/employeeTypes/addNew")
	public String addEmployeeType(EmployeeType employeeType) {
		employeeTypeService.saveEmployeeType(employeeType);
		return "redirect:/employeetypes";
	}

	@RequestMapping(value = "/employeeTypes/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateEmployeeType(EmployeeType employeeType) {
		employeeTypeService.updateEmployeeType(employeeType);
		return "redirect:/employeetypes";
	}

	@RequestMapping(value = "/employeeTypes/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String deleteEmployeeType(int id) {
		employeeTypeService.deleteEmployeeType(id);
		return "redirect:/employeetypes";
	}
	

}
