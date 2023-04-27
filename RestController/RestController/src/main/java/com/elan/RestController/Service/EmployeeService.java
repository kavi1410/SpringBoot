package com.elan.RestController.Service;

import com.elan.RestController.DAO.Employee_details;
import com.elan.RestController.DTO.EmployeeTransfer;
import com.elan.RestController.Repository.EmpRepository;
import com.elan.RestController.Message.CustomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    EmpRepository empRepository;


    public ResponseEntity getallDeatils() {
        CustomMessage message = new CustomMessage();
        ResponseEntity responseEntity;
        Iterable<Employee_details> iterable = empRepository.findAll();

        Iterator<Employee_details> iterator = iterable.iterator();

        ArrayList<Employee_details> l = new ArrayList<>();

        while (iterator.hasNext()) {
            l.add(iterator.next());

        }
        //below code will return the response code + employee details data
        responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).body(l);
        return responseEntity;
    }

    public ResponseEntity ad_Details(String eName, String eRole, double eSalary, String eUserName, String ePassword, LocalDate eDOB) {
        ResponseEntity responseEntity;
        CustomMessage message = new CustomMessage();
        Employee_details employeeDetails = new Employee_details();
        
        employeeDetails.setEName(eName);
        employeeDetails.setEDOB(eDOB);
        employeeDetails.setESalary(eSalary);
        employeeDetails.setERole(eRole);
        employeeDetails.setEPassowrd(ePassword);
        employeeDetails.setEUserName(eUserName);
        responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).body(empRepository.save(employeeDetails));
        return responseEntity;
    }

    public ResponseEntity AddDeatils(EmployeeTransfer employeeTransfer) {
        ResponseEntity responseEntity;
        Employee_details employeeDetails = new Employee_details();

        employeeDetails.setEName(employeeTransfer.getEName());

        employeeDetails.setERole(employeeTransfer.getERole());
        employeeDetails.setESalary(employeeTransfer.getESalary());
        employeeDetails.setEPassowrd(employeeTransfer.getEPassword());
        employeeDetails.setEUserName(employeeTransfer.getEUserName());
        employeeDetails.setEDOB(LocalDate.parse(employeeTransfer.getEDOB().format(DateTimeFormatter.ofPattern("yyy-MM-dd"))));
        employeeDetails = empRepository.save(employeeDetails);

        employeeTransfer.setEId(employeeDetails.getEId());
        employeeTransfer.setEName(employeeDetails.getEName());
        employeeTransfer.setESalary(employeeDetails.getESalary());
        employeeTransfer.setERole(employeeDetails.getERole());
        employeeTransfer.setEDOB(employeeDetails.getEDOB());
        employeeTransfer.setEUserName(employeeTransfer.getEUserName());
        employeeTransfer.setECreatedDateTime(employeeDetails.getECreatedDateTime());

       // employeeTransfer.setEPassword(employeeTransfer.getEPasswordreturn());
        responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeTransfer);

        return responseEntity;

    }

    public ResponseEntity Delete(int eId) {
        ResponseEntity responseEntity;
        CustomMessage message = new CustomMessage();
        Optional<Employee_details> employeeDetails = empRepository.findById(eId);

        if (employeeDetails.isPresent()) {
            empRepository.deleteById(eId);
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(message.Delete());
            return responseEntity;
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(message.idNotfound());
            return responseEntity;
        }
    }

    public ResponseEntity<Employee_details> Update(int eId, Employee_details employeeDetails) {
        ResponseEntity responseEntity;
        Optional<Employee_details> employeeDetails1 = empRepository.findById(eId);
        CustomMessage message = new CustomMessage();
        if (employeeDetails1.isPresent()) {
            employeeDetails.setEId(eId);
            Employee_details emp = empRepository.save(employeeDetails);
            responseEntity = (emp.getEName().equals(employeeDetails.getEName())) ? (ResponseEntity.status(HttpStatus.ACCEPTED).body(message.Update())) : (ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(message.idNotfound()));

            return responseEntity;
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(message.idNotfound());
            return responseEntity;
        }
    }

    public ResponseEntity<Employee_details> GetById(int eId) {
        ResponseEntity responseEntity;
        CustomMessage message = new CustomMessage();
        Optional<Employee_details> employeeDetails = empRepository.findById(eId);
        if (employeeDetails.isPresent()) {
            responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeDetails.get());
            return responseEntity;
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(message.idNotfound());
            return responseEntity;
        }
    }

    public ResponseEntity<Employee_details> getByeName(String eName) {
        ResponseEntity responseEntity;
        CustomMessage message = new CustomMessage();
       List<Employee_details> employeeDetails = empRepository.findByeName(eName);
       responseEntity = (!employeeDetails.isEmpty())?(ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeDetails)):(ResponseEntity.status(HttpStatus.NOT_FOUND).body(message.dataNotfound()));
        return responseEntity;//=ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeDetails) ;
    }


}
