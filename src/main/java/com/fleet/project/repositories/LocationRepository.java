package com.fleet.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.project.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
