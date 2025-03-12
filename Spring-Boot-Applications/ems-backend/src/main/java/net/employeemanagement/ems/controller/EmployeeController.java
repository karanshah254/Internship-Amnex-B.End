package net.employeemanagement.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.employeemanagement.ems.dto.EmployeeDTO;
import net.employeemanagement.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // Build you api contoller here
    @PostMapping("create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDTO> updatedEmployee(@PathVariable("id") Long employeeId,
            @RequestBody EmployeeDTO updaEmployeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeId, updaEmployeeDTO);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}
