package com.elan.RestController.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;
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

    private String ePassword;


    private  String eDOB;
    //private LocalDate eDOB = LocalDate.parse("YYY-MM_DD");

}
