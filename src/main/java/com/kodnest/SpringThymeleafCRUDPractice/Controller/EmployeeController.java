package com.kodnest.SpringThymeleafCRUDPractice.Controller;

import com.kodnest.SpringThymeleafCRUDPractice.Entity.Employee;
import com.kodnest.SpringThymeleafCRUDPractice.Service.EmpServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/curd")
public class EmployeeController {
    EmpServiceImplementation ref;
@Autowired
    public EmployeeController(EmpServiceImplementation ref) {
        this.ref = ref;
    }

    @GetMapping("/allemployees")
    public String findAllEmp(Model model){
    model.addAttribute("employees", ref.findAll());
    return "allEmployees";
    }
    @GetMapping("/allbysortedname")
    public String allBySortedName(Model model){
    model.addAttribute("employees", ref.findAllByOrderByNameAsc());
    return "allEmployees";
    }
    @GetMapping("/allbysortedid")
    public String allBySortedId(Model model){
    model.addAttribute("employees", ref.findAllByOrderByIdAsc());
    return "allEmployees";
    }

    @GetMapping("/byid/{id}")
    public String getById(@PathVariable int id, Model model){

    model.addAttribute("employees", ref.findById(id));
    return "allEmoloyees";
    }

    @GetMapping("/update/{id}")
    public String updateById(@PathVariable int id ,Model model){
    model.addAttribute("employee", ref.findById(id));
    return "updateEmp";
    }

    @GetMapping("/new")
    public String addNewEmp(Model model){
    model.addAttribute("employee",new Employee());
    return "addNewEmp";
    }
    @PostMapping("/save")
    public String addNewEmployee(@ModelAttribute("employee") Employee employee)
    {
        ref.save(employee);
        return "redirect:/curd/allemployees";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
    ref.save(employee);
    return "redirect:/curd/allemployees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id ,Model model){
    ref.delete(id);
        System.out.println("hello");

    return "redirect:/curd/allemployees";
    }

}
