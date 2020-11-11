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
import com.fleet.project.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public String getCountries(Model model) {

		List<Country> countryList = countryService.getCountries();

		model.addAttribute("countries", countryList);

		return "Country";
	}

	@GetMapping("/countries/findById")
	@ResponseBody
	public Optional<Country> findById(int id) {
		return countryService.findById(id);

	}

	@PostMapping("/countries/addnew")
	public String addCountry(Country country) {
		countryService.saveCountry(country);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/countries/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateCountry(Country country) {
		countryService.updateCountry(country);
		return "redirect:/countries";
	}
	
	@RequestMapping(value = "/countries/delete", method = { RequestMethod.GET, RequestMethod.DELETE})
	public String deleteCountry(int id) {
		countryService.deleteCountry(id);
		return "redirect:/countries";
	}

}
