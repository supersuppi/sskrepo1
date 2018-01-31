package com.ssk.mozy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.mozy.model.Partner;
import com.ssk.mozy.service.PartnerService;

@RestController
@RequestMapping("/api/v1")
public class PartnerController {
	
	@Autowired
	PartnerService partnerService;
	 
	 @GetMapping("/partners")
	 public ResponseEntity<List<Partner>> getAllPartners() {
		System.out.println("getAllPartners");
		 
		 List<Partner> allPartners = partnerService.getAllPartner();
		 
		 if(allPartners.size() == 0) {
		        return ResponseEntity.notFound().build();
		    }
		    return ResponseEntity.ok().body(allPartners);

	 }

}
