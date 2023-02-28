package com.ezinne.employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.listOfEmployeesAndSalaries();
    }

    @PostMapping
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployeeById(@PathVariable Long employeeId) {
        return employeeService.findEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployeeDetails(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployeeDetails(employeeId, employeeDTO);
    }

    @DeleteMapping("/employeeId")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
