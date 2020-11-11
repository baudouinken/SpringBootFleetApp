package com.fleet.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.project.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
