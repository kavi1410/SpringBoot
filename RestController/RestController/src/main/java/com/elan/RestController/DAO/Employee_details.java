package com.elan.RestController.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "employee_details")
@DynamicUpdate

public class Employee_details {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "ID")
    private Integer eId;
    //@NonNull
    @Column(name = "NAME")
    private String eName;

    @Column(name = "ROLE")
    private String eRole;
    @Column(name = "SALARY")
    private double eSalary;
    @Column(name = "USERNAME")
    //@NonNull
    private String eUserName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name ="password")
    //@NonNull
    private String ePassowrd;

    @Column(name = "DOB")
    //@Temporal(value = TemporalType.DATE)
    private LocalDate eDOB;
    //private  String eDOB;


    @Column(name = "createddatetime")
    private LocalDateTime eCreatedDateTime = LocalDateTime.now();

//    @Override
//    public String toString() {
//        return "Employee_details{" +
//                "eId=" + eId +
//                ", eName='" + eName + '\'' +
//                ", eRole='" + eRole + '\'' +
//                ", eSalary=" + eSalary +
//                ", eUserName='" + eUserName + '\'' +
//                ", ePassword='" + ePassword + '\'' +
//                ", eDOB=" + eDOB +
//                '}';
//    }



}