package com.zohocrm.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.Entities.Lead;
import com.zohocrm.Repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;
	
	
	@Override
	public void saveOneLead(Lead l) {
         leadRepo.save(l);
	}


	@Override
	public Lead findLeadByID(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}


	@Override
	public void deleteLeadById(long id) {
		 leadRepo.deleteById(id);
	}


	@Override
	public List<Lead> getAllLead() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

}
