package com.demo.leadManagement.util;

import com.demo.leadManagement.dto.LeadDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static Boolean detailsValidator(LeadDTO lead) {
        return isLeadIdValid(lead.getLeadId()) &&
                isFirstNameValid(lead.getFirstName()) &&
                isMiddleNameValid(lead.getMiddleName()) &&
                isLastNameValid(lead.getLastName()) &&
                isMobileNumberValid(lead.getMobileNumber()) &&
                isGenderValid(lead.getGender()) &&
                isDobValid(lead.getDob()) &&
                isEmailValid(lead.getEmail());
    }

    private static boolean isLeadIdValid(Long leadId) {
        return leadId != null && leadId > 0;
    }

    private static boolean isFirstNameValid(String firstName) {
        return firstName != null && firstName.matches("[A-Za-z]+");
    }

    private static boolean isMiddleNameValid(String middleName) {
        return middleName == null || middleName.matches("[A-Za-z]+");
    }

    private static boolean isLastNameValid(String lastName) {
        return lastName != null && lastName.matches("[A-Za-z]+");
    }

    private static boolean isMobileNumberValid(String mobileNumber) {
        return mobileNumber != null && mobileNumber.matches("[6-9]\\d{9}");
    }

    private static boolean isGenderValid(String gender) {
        return gender != null && gender.matches("Male|Female|Others");
    }

    private static boolean isDobValid(Date dob) {
        if (dob == null) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse((CharSequence) dob, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
