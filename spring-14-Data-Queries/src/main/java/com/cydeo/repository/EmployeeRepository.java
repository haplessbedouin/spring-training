package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display all employees with email address ""
    List<Employee> findByEmail(String pattern);

    //Display all employees with firstname "" and last name "",
    //Also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstNameIsNot);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salaryGreaterThan);

    //Display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan(Integer salaryLessThan);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate date1, LocalDate date2);

    //Display all employees where salaries greater and equal to "" in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryAsc(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that don't have email address
    List<Employee> findByEmailIsNull();
    @Query("select e from Employee e where e.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();
    @Query("select e.salary from Employee e where e.email='amcnee1@google.es'")
    Employee retrieveEmployeeSalary();



}
