package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //Not Equal
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like / Contains / StartsWith / EndsWith
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less Than
    @Query("select e from Employee e where e.salary<?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //Greater Than
    @Query("select e.firstName from Employee e where e.salary>?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);


    //Between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //BEFORE
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //NULL
    @Query("select e from Employee e where e.email is null ")
    List<Employee> retrieveEmployeeEmailIsNull();

    //NOT NULL

    @Query("select e from Employee e where e.email is not null ")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //SORTING in Asc Order
    @Query("select e from Employee e order by e.salary ")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //SORTING in Desc Order
    @Query("select e from Employee e order by e.salary desc ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Native Query
    @Query(value = "select * from employees where salary = ?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //Named Parameter
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary")int salary);




}
