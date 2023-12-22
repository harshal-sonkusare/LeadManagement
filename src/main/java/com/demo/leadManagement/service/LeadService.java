package com.demo.leadManagement.service;

import com.demo.leadManagement.dto.LeadDTO;
import com.demo.leadManagement.dto.Response;
import com.demo.leadManagement.entity.LeadEntity;
import com.demo.leadManagement.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static com.demo.leadManagement.util.Validators.detailsValidator;

public class LeadService {

    private final LeadRepository leadRepository;
    private final Response response;

    public LeadService(@Autowired LeadRepository leadRepository,
                       @Autowired Response response) {
        this.leadRepository = leadRepository;
        this.response = response;
    }

    public void saveLeadDetails(LeadDTO leadRequest) {

        Boolean validationResult = detailsValidator(leadRequest);

        if (validationResult.equals(true)) {
            mapAndSave(leadRequest);
        }
    }

    private void mapAndSave(LeadDTO leadRequest) {
        LeadEntity leadEntity = new LeadEntity();
        leadEntity.setId(leadRequest.getLeadId());
        leadEntity.setFirstName(leadRequest.getFirstName());
        leadEntity.setMiddleName(leadRequest.getMiddleName());
        leadEntity.setLastName(leadRequest.getLastName());
        leadEntity.setMobileNumber(leadRequest.getMobileNumber());
        leadEntity.setGender(leadRequest.getGender());
        leadEntity.setDob(leadRequest.getDob());
        leadEntity.setEmail(leadRequest.getEmail());
        leadEntity = leadRepository.saveAndFlush(leadEntity);
    }
}
