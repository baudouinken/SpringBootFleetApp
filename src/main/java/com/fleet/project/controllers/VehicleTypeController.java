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

import com.fleet.project.models.VehicleType;
import com.fleet.project.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicletypes")
	public String getVehicleTypes(Model model) {

		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypeList);

		return "VehicleType";
	}

	@GetMapping("/vehicleTypes/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeService.findById(id);

	}

	@PostMapping("/vehicleTypes/addNew")
	public String addVehicleType(VehicleType vehicleType) {
		vehicleTypeService.saveVehicleType(vehicleType);
		return "redirect:/vehicletypes";
	}

	@RequestMapping(value = "/vehicleTypes/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateVehicleType(VehicleType vehicleType) {
		vehicleTypeService.updateVehicleType(vehicleType);
		return "redirect:/vehicletypes";
	}

	@RequestMapping(value = "/vehicleTypes/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String deleteVehicleType(int id) {
		vehicleTypeService.deleteVehicleType(id);
		return "redirect:/vehicletypes";
	}

}
