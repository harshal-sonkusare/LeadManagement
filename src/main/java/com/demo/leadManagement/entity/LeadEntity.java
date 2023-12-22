package com.demo.leadManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@Entity
@Table(name = "LEADDETAILS")
public class LeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "MIDDDLENAME")
    private String middleName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "MOBILENUMBER")
    private String mobileNumber;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "EMAIL")
    private String email;

    public LeadEntity() {

    }
}
