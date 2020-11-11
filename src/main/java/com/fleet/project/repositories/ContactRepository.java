package com.fleet.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.project.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
