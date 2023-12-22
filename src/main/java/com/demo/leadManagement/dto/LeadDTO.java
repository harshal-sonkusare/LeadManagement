package com.demo.leadManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class LeadDTO implements Serializable {
    private Long leadId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNumber;
    private String gender;
    private Date dob;
    private String email;
}
