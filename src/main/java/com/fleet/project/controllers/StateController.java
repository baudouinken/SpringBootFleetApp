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
import com.fleet.project.models.State;
import com.fleet.project.services.CountryService;
import com.fleet.project.services.StateService;

@Controller
public class StateController {

	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;

	@GetMapping("/states")
	public String getStates(Model model) {

		List<State> stateList = stateService.getStates();
		model.addAttribute("states", stateList);
		
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);

		return "State";
	}

	@GetMapping("states/findById")
	@ResponseBody
	public Optional<State> findById(int id) {
		return stateService.findById(id);

	}

	@PostMapping("/states/addNew")
	public String addState(State state) {
		stateService.saveState(state);
		return "redirect:/states";
	}

	@RequestMapping(value = "/states/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateState(State state) {
		stateService.updateState(state);
		return "redirect:/states";
	}
	
	@RequestMapping(value = "/states/delete", method = { RequestMethod.GET, RequestMethod.DELETE})
	public String deleteState(int id) {
		stateService.deleteState(id);
		return "redirect:/states";
	}
	

}
