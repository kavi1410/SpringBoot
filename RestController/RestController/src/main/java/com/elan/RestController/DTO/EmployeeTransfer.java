package com.elan.RestController.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTransfer {

    private Integer eId;

    private String eName;

    private String eRole;

    private double eSalary;

    private String eUserName;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String ePassword;


    //private  String eDOB;
    private LocalDate eDOB;

    private LocalDateTime eCreatedDateTime;



}
