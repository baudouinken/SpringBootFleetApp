package com.fleet.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.project.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
