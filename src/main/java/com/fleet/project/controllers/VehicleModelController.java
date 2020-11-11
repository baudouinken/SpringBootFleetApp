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

import com.fleet.project.models.VehicleModel;
import com.fleet.project.services.VehicleModelService;

@Controller
public class VehicleModelController {
	
	@Autowired
	private VehicleModelService vehicleModelService;

	@GetMapping("/vehiclemodels")
	public String getVehicleModels(Model model) {

		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels", vehicleModelList);

		return "VehicleModel";
	}

	@GetMapping("/vehicleModels/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelService.findById(id);

	}

	@PostMapping("/vehicleModels/addNew")
	public String addVehicleModel(VehicleModel vehicleModel) {
		vehicleModelService.saveVehicleModel(vehicleModel);
		return "redirect:/vehiclemodels";
	}

	@RequestMapping(value = "/vehicleModels/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateVehicleModel(VehicleModel vehicleModel) {
		vehicleModelService.updateVehicleModel(vehicleModel);
		return "redirect:/vehiclemodels";
	}

	@RequestMapping(value = "/vehicleModels/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String deleteVehicleModel(int id) {
		vehicleModelService.deleteVehicleModel(id);
		return "redirect:/vehiclemodels";
	}
	

}
