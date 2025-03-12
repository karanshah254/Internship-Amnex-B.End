package net.employeemanagement.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.employeemanagement.ems.dto.EmployeeDTO;
import net.employeemanagement.ems.entity.Employee;
import net.employeemanagement.ems.exception.ResourceNotFoundException;
import net.employeemanagement.ems.mapper.EmployeeMapper;
import net.employeemanagement.ems.repository.EmployeeRepository;
import net.employeemanagement.ems.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setFirstName(updatedEmployeeDTO.getFirstName());
        employee.setLastName(updatedEmployeeDTO.getLastName());
        employee.setEmailId(updatedEmployeeDTO.getEmail());

        Employee updatedEmployeeObject = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObject);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }
}
