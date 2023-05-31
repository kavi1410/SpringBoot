package com.elan.RestController.Validation;

import com.elan.RestController.CustomException.UserDetailsException;
import com.elan.RestController.DAO.Employee_details;
import com.elan.RestController.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomValidation {

    @Autowired
    EmpRepository empRepository;

    public Boolean check(Employee_details employee_details){

        List<String> ErrorList = new ArrayList<>();
        List<String> DetailList =  new ArrayList<>();
        String username=employee_details.getEUserName();
        List<Employee_details> employeeDetails = empRepository.findByeUserName(username);
        if(!employeeDetails.isEmpty()){
            System.out.println("not empty");
            ErrorList.add("User Name Already Exist");
            DetailList.add("User name should be unique");
        }
        System.out.println("kavi"+employee_details.getEName()+employee_details.getEName().length());
        System.out.println(employee_details.getEName().length() <= 1);
        if(employee_details.getEName().length() <= 1 || employee_details.getEName().length() >20 ){
            ErrorList.add("Name doesn't match the requirement");
            DetailList.add("name character should be more than 2 and less than 20");
        }
        System.out.println("list"+ErrorList);
        System.out.println("list"+DetailList+DetailList.isEmpty());
        if ((ErrorList.isEmpty()) && (DetailList.isEmpty())) {

            return true;
        }
        throw new UserDetailsException(ErrorList,DetailList);
    }
}