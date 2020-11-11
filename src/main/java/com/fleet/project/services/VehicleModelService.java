package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.VehicleModel;
import com.fleet.project.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	
	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	// return a list of vehicleModels
	public List<VehicleModel> getVehicleModels() {
		return vehicleModelRepository.findAll();
	}

	// Save new VehicleModel
	public void saveVehicleModel(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}

	// Update VehicleModel
	public void updateVehicleModel(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}

	// Update VehicleModel
	public void deleteVehicleModel(int id) {
		vehicleModelRepository.deleteById(id);
	}

	// get by id
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

}
