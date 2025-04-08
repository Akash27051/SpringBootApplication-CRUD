package com.kodnest.SpringThymeleafCRUDPractice.Repository;

import com.kodnest.SpringThymeleafCRUDPractice.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeJpa extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByOrderByNameAsc();
    public List<Employee> findAllByOrderByIdAsc();
}
