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

import com.fleet.project.models.VehicleStatus;
import com.fleet.project.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	
	@Autowired
	private VehicleStatusService vehicleStatusService;

	@GetMapping("/statusvalues")
	public String getVehicleStatus(Model model) {

		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
		model.addAttribute("vehicleStatus", vehicleStatusList);

		return "VehicleStatus";
	}

	@GetMapping("/vehicleStatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusService.findById(id);

	}

	@PostMapping("/vehicleStatuss/addNew")
	public String addVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusService.saveVehicleStatus(vehicleStatus);
		return "redirect:/statusvalues";
	}

	@RequestMapping(value = "/vehicleStatuss/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusService.updateVehicleStatus(vehicleStatus);
		return "redirect:/statusvalues";
	}

	@RequestMapping(value = "/vehicleStatus/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String deleteVehicleStatus(int id) {
		vehicleStatusService.deleteVehicleStatus(id);
		return "redirect:/statusvalues";
	}
	

}
