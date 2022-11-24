package com.zohocrm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.zohocrm.Entities.Contact;
import com.zohocrm.Entities.Lead;
import com.zohocrm.Services.ContactService;
import com.zohocrm.Services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;

	//http://localhost:8080/zohocrmapp/viewcreatepage
	  @GetMapping("/viewcreatepage")
	  public String viewCreateLeadPage() {
		  return "Create_New_Lead";
	  }
	  @PostMapping("/save")
	  public String saveLead(@ModelAttribute("lead") Lead l , ModelMap model) {
		  leadService.saveOneLead(l);
		  model.addAttribute("lead", l);
		  return"lead_info";
		  
	  }
	  @PostMapping("/convertLead")
	  public String converLead(@RequestParam("id")long id , Model model) {
		  Lead lead = leadService.findLeadByID(id);
		  Contact contact = new Contact();
		  contact.setFirstName(lead.getFirstName());
		  contact.setLastName(lead.getLastName());
		  contact.setEmail(lead.getEmail());
		  contact.setMobile(lead.getMobile());
		  contact.setSource(lead.getSource());
		  
		  contactService.saveContact(contact);
		  
		  leadService.deleteLeadById( id);
		  List<Contact> contacts = contactService.getAllContacts();
		  model.addAttribute("contacts", contacts);
		  return "list_contacts";
	  }
	  @RequestMapping("/listAll")
	  public String listAllLeads(Model model) {
		  List<Lead> leads = leadService.getAllLead();
		  model.addAttribute("leads", leads);
		  return "list_leads";
	  }
	  @RequestMapping("/leadInfo")
	  public String leadInfo(@RequestParam ("id")long id , Model model) {
		  Lead lead = leadService.findLeadByID(id);
		  model.addAttribute("lead", lead);
		  return"lead_info";
	  }
}
