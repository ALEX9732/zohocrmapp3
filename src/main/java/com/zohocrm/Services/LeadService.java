

package com.zohocrm.Services;

import java.util.List;

import com.zohocrm.Entities.Lead;

public interface LeadService {
public void saveOneLead(Lead l);

public Lead findLeadByID(long id);

public void deleteLeadById(long id);

public List<Lead> getAllLead();
}
