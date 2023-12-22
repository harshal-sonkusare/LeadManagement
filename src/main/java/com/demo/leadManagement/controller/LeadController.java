package com.demo.leadManagement.controller;

import com.demo.leadManagement.dto.LeadDTO;
import com.demo.leadManagement.dto.Response;
import com.demo.leadManagement.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lead")
public class LeadController {

    private LeadService leadService;

    public LeadController(@Autowired LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping(value = "/saveLead", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response saveLead(@RequestBody LeadDTO leadRequest) {
        leadService.saveLeadDetails(leadRequest);
        //todo:
        return null;
    }
}
