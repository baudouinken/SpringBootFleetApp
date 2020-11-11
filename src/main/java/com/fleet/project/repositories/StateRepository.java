package com.fleet.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.project.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
