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

import com.fleet.project.models.VehicleMake;
import com.fleet.project.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	
	@Autowired
	private VehicleMakeService vehicleMakeService;

	@GetMapping("/vehiclemakes")
	public String getVehicleMakes(Model model) {

		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakeList);

		return "VehicleMake";
	}

	@GetMapping("/vehicleMakes/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeService.findById(id);

	}

	@PostMapping("/vehicleMakes/addNew")
	public String addVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeService.saveVehicleMake(vehicleMake);
		return "redirect:/vehiclemakes";
	}

	@RequestMapping(value = "/vehicleMakes/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeService.updateVehicleMake(vehicleMake);
		return "redirect:/vehiclemakes";
	}

	@RequestMapping(value = "/vehicleMakes/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String deleteVehicleMake(int id) {
		vehicleMakeService.deleteVehicleMake(id);
		return "redirect:/vehiclemakes";
	}

}
