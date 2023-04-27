package com.elan.RestController.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor(force = true)
//@AllArgsConstructor

@Entity
@Table(name = "employee_details")

public class Employee_details {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "eId")
    private Integer eId;
    //@NonNull
    @Column(name = "eName")
    private String eName;
    @NonNull
    @Column(name = "eRole")
    private String eRole;
    @Column(name = "eSalary")
    private double eSalary;
    @Column(name = "eUserName")
    @NonNull
    private String eUserName;
    @Column(name = "ePassword")
    @NonNull
    private String ePassword;

    @Column(name = "eDOB")
  //  @Temporal(value = TemporalType.DATE)
    //private LocalDate eDOB = LocalDate.parse("YYY-MM-DD");
    private  String eDOB;
    

    @Override
    public String toString() {
        return "Employee_details{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", eRole='" + eRole + '\'' +
                ", eSalary=" + eSalary +
                ", eUserName='" + eUserName + '\'' +
                ", ePassword='" + ePassword + '\'' +
                ", eDOB=" + eDOB +
                '}';
    }



}


