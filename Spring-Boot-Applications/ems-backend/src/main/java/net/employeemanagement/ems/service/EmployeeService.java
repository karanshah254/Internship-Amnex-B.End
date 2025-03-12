package net.employeemanagement.ems.service;

import java.util.List;

import net.employeemanagement.ems.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployeeDTO);

    void deleteEmployee(Long id);
}
