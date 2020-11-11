package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.Country;
import com.fleet.project.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	// return a list of countries
	public List<Country> getCountries() {
		return countryRepository.findAll();
	}

	// Save new Country
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}

	// Update Country
	public void updateCountry(Country country) {
		countryRepository.save(country);
	}

	// Update Country
	public void deleteCountry(int id) {
		countryRepository.deleteById(id);
	}

	// get by id
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}

}
