package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.State;
import com.fleet.project.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;

	// return a list of states
	public List<State> getStates() {
		return stateRepository.findAll();
	}

	// Save new State
	public void saveState(State state) {
		stateRepository.save(state);
	}

	// Update State
	public void updateState(State state) {
		stateRepository.save(state);
	}

	// Update State
	public void deleteState(int id) {
		stateRepository.deleteById(id);
	}

	// get by id
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}

}
