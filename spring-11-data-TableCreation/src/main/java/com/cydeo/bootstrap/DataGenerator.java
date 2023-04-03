package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.entity.Departments;
import com.cydeo.entity.Employee;
import com.cydeo.entity.Employees;
import com.cydeo.enums.Gender;
import com.cydeo.repository.CarRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {
    private final CarRepository carRepository;
    private final EmployeesRepository employeesRepository;
    private final DepartmentRepository departmentRepository;

    public DataGenerator(CarRepository carRepository, EmployeesRepository employeesRepository, DepartmentRepository departmentRepository) {
        this.carRepository = carRepository;
        this.employeesRepository = employeesRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car c1 = new Car("BMW", "M3");
        Car c2 = new Car("Honda", "Accord");
        Car c3 = new Car("Toyota", "Corolla");

        //I want to save c1,c2,c3 to database

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

        List<Employees> employeesList = new ArrayList<>();
        List<Departments> departmentsList = new ArrayList<>();

        Departments d1 = new Departments("Fire", "C8");
        Departments d2 = new Departments("Police", "E6");
        Departments d3 = new Departments("Military", "B4");
        Departments d4 = new Departments("Home Land Security", "G3");
        Departments d5 = new Departments("National Guardian", "T9");

        Employees e1 = new Employees("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20), Gender.FEMALE, 2500);
        Employees e2 = new Employees("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,01,26), Gender.FEMALE, 2500);
        Employees e3 = new Employees("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17), Gender.FEMALE, 2500);
        Employees e4 = new Employees("Avrom", "Rowantree", null, LocalDate.of(2014,03,02), Gender.MALE, 2500);
        Employees e5 = new Employees("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), Gender.MALE, 2500);

        employeesRepository.saveAll(employeesList);
        departmentRepository.saveAll(departmentsList);

    }

}
