package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.VehicleType;
import com.fleet.project.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	// return a list of vehicleTypes
	public List<VehicleType> getVehicleTypes() {
		return vehicleTypeRepository.findAll();
	}

	// Save new VehicleType
	public void saveVehicleType(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}

	// Update VehicleType
	public void updateVehicleType(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}

	// Update VehicleType
	public void deleteVehicleType(int id) {
		vehicleTypeRepository.deleteById(id);
	}

	// get by id
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}

}
