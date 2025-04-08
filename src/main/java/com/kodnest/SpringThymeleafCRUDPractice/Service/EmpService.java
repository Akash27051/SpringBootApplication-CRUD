package com.kodnest.SpringThymeleafCRUDPractice.Service;

import com.kodnest.SpringThymeleafCRUDPractice.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmpService {
    public List<Employee> findAll();
    public List<Employee> findAllByOrderByNameAsc();
    public List<Employee> findAllByOrderByIdAsc();

    public Employee findById(int id);
    public Employee save(Employee employee);
    public Employee delete(int id);

}
