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

import com.fleet.project.models.Country;
import com.fleet.project.models.Location;
import com.fleet.project.models.State;
import com.fleet.project.services.CountryService;
import com.fleet.project.services.LocationService;
import com.fleet.project.services.StateService;

@Controller
public class LocationController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private LocationService locationService;

	@GetMapping("/locations")
	public String getLocations(Model model) {

		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);

		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);

		List<State> stateList = stateService.getStates();
		model.addAttribute("states", stateList);

		return "Location";
	}

	@GetMapping("locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id) {
		return locationService.findById(id);

	}

	@PostMapping("/locations/addNew")
	public String addLocation(Location location) {
		locationService.saveLocation(location);
		return "redirect:/locations";
	}

	@RequestMapping(value = "/locations/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateLocation(Location location) {
		locationService.updateLocation(location);
		return "redirect:/locations";
	}

	@RequestMapping(value = "/locations/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String deleteLocation(int id) {
		locationService.deleteLocation(id);
		return "redirect:/locations";
	}

}
