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

import com.fleet.project.models.InvoiceStatus;
import com.fleet.project.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoicestatuses")
	public String getInvoiceStatus(Model model) {

		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();
		model.addAttribute("invoiceStatus", invoiceStatusList);

		return "InvoiceStatus";
	}

	@GetMapping("/invoiceStatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusService.findById(id);

	}

	@PostMapping("/invoiceStatus/addNew")
	public String addInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusService.saveInvoiceStatus(invoiceStatus);
		return "redirect:/invoicestatuses";
	}

	@RequestMapping(value = "/invoiceStatus/update", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusService.updateInvoiceStatus(invoiceStatus);
		return "redirect:/invoicestatuses";
	}

	@RequestMapping(value = "/invoiceStatus/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String deleteInvoiceStatus(int id) {
		invoiceStatusService.deleteInvoiceStatus(id);
		return "redirect:/invoicestatuses";
	}
	

}
