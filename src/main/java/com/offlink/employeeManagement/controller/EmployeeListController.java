package com.offlink.employeeManagement.controller;


import com.offlink.employeeManagement.entity.Employee;
import com.offlink.employeeManagement.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeListController {
    // load employee data

    private EmployeeService employeeService;

    public EmployeeListController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }


    // mapping
    @GetMapping("/list")
    public String listEmployee(Model theModel) {
        // get the employee form database
        List<Employee> theEmployee = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployee);

        return "employees/list-employee";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model

        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);

        return "employees/add-employees";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

        // get the employee form the service
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model prepopulate the form
        theModel.addAttribute("employee", theEmployee);

        //return
        return "employees/add-employees";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")Employee theEmployee) {
        // save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return  "redirect:/employee/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {
        // save the employee
        employeeService.deleteById(theId);

        // redirect to the
        return "redirect:/employees/list";
    }

}
