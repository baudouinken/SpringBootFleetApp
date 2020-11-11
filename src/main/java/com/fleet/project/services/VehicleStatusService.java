package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.VehicleStatus;
import com.fleet.project.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {
	
	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;

	// return a list of vehicleStatuss
	public List<VehicleStatus> getVehicleStatus() {
		return vehicleStatusRepository.findAll();
	}

	// Save new VehicleStatus
	public void saveVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}

	// Update VehicleStatus
	public void updateVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}

	// Update VehicleStatus
	public void deleteVehicleStatus(int id) {
		vehicleStatusRepository.deleteById(id);
	}

	// get by id
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusRepository.findById(id);
	}

}
