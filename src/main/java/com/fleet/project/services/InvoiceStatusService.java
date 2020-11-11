package com.fleet.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.project.models.InvoiceStatus;
import com.fleet.project.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;

	// return a list of invoiceStatuss
	public List<InvoiceStatus> getInvoiceStatus() {
		return invoiceStatusRepository.findAll();
	}

	// Save new InvoiceStatus
	public void saveInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}

	// Update InvoiceStatus
	public void updateInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}

	// Update InvoiceStatus
	public void deleteInvoiceStatus(int id) {
		invoiceStatusRepository.deleteById(id);
	}

	// get by id
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusRepository.findById(id);
	}

}
