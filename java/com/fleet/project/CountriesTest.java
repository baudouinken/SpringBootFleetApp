package com.fleet.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fleet.project.models.Country;
import com.fleet.project.models.State;

class CountriesTest extends ItBase {

	@Test
	void saveAndGetOneCountry() {

		List<State> states = new ArrayList<State>();

		Country country = new Country(1, "test1", "test1", "test1", "test1", "test1", states);

		countryService.saveCountry(country);

		assertThat(country.equals(countryService.findById(country.getId())));

	}

	@Test
	void getAll() {

		List<State> states = new ArrayList<State>();

		Country country = new Country(1, "test1", "test1", "test1", "test1", "test1", states);

		countryService.saveCountry(country);

	}

	@Test
	void update() {

		List<State> states = new ArrayList<State>();

		Country country = new Country(1, "test1", "test1", "test1", "test1", "test1", states);

		countryService.saveCountry(country);

		country.setCapital("test2");
		country.setDescription("test2");

		countryService.saveCountry(country);

		assertThat(countryService.findById(country.getId()).equals(country));

	}

	@Test
	void delete() {

		List<State> states = new ArrayList<State>();

		Country country = new Country();

		countryService.saveCountry(country);
		countryService.deleteCountry(country.getId());

		assertFalse(countryService.findById(country.getId()).isPresent());

	}

}
