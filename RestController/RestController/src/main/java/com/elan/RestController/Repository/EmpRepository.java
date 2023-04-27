package com.elan.RestController.Repository;

import com.elan.RestController.DAO.Employee_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<Employee_details, Integer> {
    List<Employee_details> findByeName(String eName);

}
