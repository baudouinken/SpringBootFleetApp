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

import com.fleet.project.models.JobTitle;
import com.fleet.project.services.JobTitleService;

@Controller
public class JobTitleController {
	
	@Autowired
	private JobTitleService jobTitleService;

	@GetMapping("/jobtitles")
	public String getJobTitles(Model model) {

		List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
		model.addAttribute("jobTitles", jobTitleList);

		return "JobTitle";
	}

	@GetMapping("/jobTitles/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id) {
		return jobTitleService.findById(id);

	}

	@PostMapping("/jobTitles/addNew")
	public String addJobTitle(JobTitle jobTitle) {
		jobTitleService.saveJobTitle(jobTitle);
		return "redirect:/jobtitles";
	}

	@RequestMapping(value = "/jobTitles/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateJobTitle(JobTitle jobTitle) {
		jobTitleService.updateJobTitle(jobTitle);
		return "redirect:/jobtitles";
	}

	@RequestMapping(value = "/jobTitles/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String deleteJobTitle(int id) {
		jobTitleService.deleteJobTitle(id);
		return "redirect:/jobtitles";
	}
	

}
