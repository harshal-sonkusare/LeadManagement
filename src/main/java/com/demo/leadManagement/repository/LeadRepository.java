package com.demo.leadManagement.repository;

import com.demo.leadManagement.entity.LeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<LeadEntity, Long> {


}
