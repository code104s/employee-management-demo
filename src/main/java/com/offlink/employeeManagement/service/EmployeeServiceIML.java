package com.offlink.employeeManagement.service;

import com.offlink.employeeManagement.dao.EmployeeRestDAO;
import com.offlink.employeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIML implements EmployeeService{

    private EmployeeRestDAO employeeRepository;

    @Autowired
    public EmployeeServiceIML(EmployeeRestDAO theEmoloyeeRest) {
        employeeRepository = theEmoloyeeRest;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByTenAsc();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Khong tim thay id nhan vien : id = " + theId);
        }

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById((theId));
    }
}
