package com.fleet.project.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.project.models.VehicleMaintenance;
import com.fleet.project.services.SupplierService;
import com.fleet.project.services.VehicleMaintenanceService;
import com.fleet.project.services.VehicleService;

@Controller
public class VehicleMaintenanceController {
	
	@Autowired	private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired	private VehicleService vehicleService;
	@Autowired	private SupplierService supplierService;


	@GetMapping("/vehiclemaintenances")
	public String getVehicleMaintenances(Model model) {		
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());	
		
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("suppliers", supplierService.getSuppliers());
		

		
		return "VehicleMaintenance";
	}	
	
	@PostMapping("/vehicleMaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenances";
	}
	
	@RequestMapping("/vehicleMaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id) {
	  return vehicleMaintenanceService.findById(id);	
	}	
	
	@RequestMapping(value="/vehicleMaintenances/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenances";
	}
	
	@RequestMapping(value="/vehicleMaintenances/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehiclemaintenances";
	}
	

}
