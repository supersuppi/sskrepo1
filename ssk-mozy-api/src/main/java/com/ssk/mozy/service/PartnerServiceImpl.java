package com.ssk.mozy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssk.mozy.model.Partner;
import com.ssk.mozy.repository.PartnerRepo;

@Service
public class PartnerServiceImpl implements PartnerService{

	 @Autowired
	 PartnerRepo partnerRepository;

	@Override
	public List<Partner> getAllPartner() {
		 return partnerRepository.findAll();
	}
}
