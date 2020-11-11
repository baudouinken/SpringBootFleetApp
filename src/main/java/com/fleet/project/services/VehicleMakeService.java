package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.VehicleMake;
import com.fleet.project.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;

	// return a list of vehicleMakes
	public List<VehicleMake> getVehicleMakes() {
		return vehicleMakeRepository.findAll();
	}

	// Save new VehicleMake
	public void saveVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}

	// Update VehicleMake
	public void updateVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}

	// Update VehicleMake
	public void deleteVehicleMake(int id) {
		vehicleMakeRepository.deleteById(id);
	}

	// get by id
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}

}
