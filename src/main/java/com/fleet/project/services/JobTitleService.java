package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.JobTitle;
import com.fleet.project.repositories.JobTitleRepository;

@Service
public class JobTitleService {
	
	@Autowired
	private JobTitleRepository jobTitleRepository;

	// return a list of jobTitles
	public List<JobTitle> getJobTitles() {
		return jobTitleRepository.findAll();
	}

	// Save new JobTitle
	public void saveJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}

	// Update JobTitle
	public void updateJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}

	// Update JobTitle
	public void deleteJobTitle(int id) {
		jobTitleRepository.deleteById(id);
	}

	// get by id
	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}

}
