package com.elan.RestController.controller;
import com.elan.RestController.DAO.Employee_details;
import com.elan.RestController.DTO.EmployeeTransfer;
import com.elan.RestController.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/all")
    public @ResponseBody ResponseEntity getalldetails(){
        return employeeService.getallDeatils();
    }

    @PostMapping(path = "/ad")
    //by parameter we can save the values in DB using the requestparam annotation
    public @ResponseBody ResponseEntity<Employee_details> AddDetails( @RequestParam String eName, @RequestParam String eRole,@RequestParam double eSalary,@RequestParam  String eUserName,@RequestParam String ePassword,@RequestParam LocalDate eDOB){
        return employeeService.ad_Details(eName,eRole,eSalary,eUserName, ePassword,  eDOB);
    }

    // By JSON format we can pass/ save the values by using the requestbody annotation
    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody EmployeeTransfer employeeTransfer){

        return employeeService.AddDeatils(employeeTransfer);
    }
    @DeleteMapping(value = "delete/{eId}")

    public ResponseEntity<Employee_details> delete(@PathVariable("eId") int eId) {
        return employeeService.Delete(eId);

    }

    @PatchMapping(value = "update/{eId}")

    public ResponseEntity<Employee_details> updateDetails(@PathVariable("eId") int eId, @RequestBody Employee_details employeeDetails){
        return employeeService.Update(eId,employeeDetails);
    }

    @GetMapping(value = "get/eId/{eId}")

    public ResponseEntity<Employee_details> getbyId(@PathVariable("eId") int eId) {

       return employeeService.GetById(eId);
    }
    @GetMapping(value = "get/eName/{eName}")

    public ResponseEntity<Employee_details> getByName(@PathVariable("eName") String eName){
        return employeeService.getByeName(eName);
    }
}
