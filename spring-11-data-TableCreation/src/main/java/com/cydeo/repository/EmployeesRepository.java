package com.cydeo.repository;

import com.cydeo.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeesRepository extends JpaRepository<Employees,Long> {
}
