package com.ssk.mozy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssk.mozy.model.Partner;

@Repository
public interface PartnerRepo extends JpaRepository<Partner, Long> {

}
