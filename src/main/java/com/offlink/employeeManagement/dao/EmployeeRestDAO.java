package com.offlink.employeeManagement.dao;

import com.offlink.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRestDAO extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByTenAsc();
}
