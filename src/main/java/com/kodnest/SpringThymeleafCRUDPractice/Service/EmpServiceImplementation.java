package com.kodnest.SpringThymeleafCRUDPractice.Service;

import com.kodnest.SpringThymeleafCRUDPractice.Entity.Employee;
import com.kodnest.SpringThymeleafCRUDPractice.Repository.EmployeeJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImplementation implements EmpService{
    EmployeeJpa ref;
@Autowired
    public EmpServiceImplementation(EmployeeJpa ref) {
        this.ref = ref;
    }

    @Override
    public List<Employee> findAll() {
    return ref.findAll();
    }

    @Override
    public List<Employee> findAllByOrderByNameAsc() {
        return ref.findAllByOrderByNameAsc();
    }

    @Override
    public List<Employee> findAllByOrderByIdAsc() {
        return ref.findAllByOrderByIdAsc();
    }

    @Override
    public Employee findById(int id) {
    Optional<Employee> opem =ref.findById(id);
    return opem.get();
    }

    @Override
    public Employee save(Employee employee) {
    ref.save(employee);
        return employee;
    }

    @Override
    public Employee delete(int id) {
        Optional<Employee> opem =ref.findById(id);
        Employee employee=opem.get();
    ref.delete(employee);
        return employee;
    }
}
