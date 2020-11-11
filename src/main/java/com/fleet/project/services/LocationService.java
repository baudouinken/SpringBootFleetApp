package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.Location;
import com.fleet.project.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	// return a list of locations
	public List<Location> getLocations() {
		return locationRepository.findAll();
	}

	// Save new Location
	public void saveLocation(Location location) {
		locationRepository.save(location);
	}

	// Update Location
	public void updateLocation(Location location) {
		locationRepository.save(location);
	}

	// Update Location
	public void deleteLocation(int id) {
		locationRepository.deleteById(id);
	}

	// get by id
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

}
