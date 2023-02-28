package com.ezinne.employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.List;
import java.util.ListIterator;

@Service
@AllArgsConstructor
public class EmployeeService implements SalaryCalculatorService,
         EmployeeNotFoundException, EmployeeDTOToEmployeeMapper {
    private EmployeeRepository employeeRepository;


    public List<Employee> listOfEmployeesAndSalaries() {

        return employeeRepository.findAll();
    }

    public String createNewEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapEmployeeDTOToEmployee(employeeDTO);
         employeeRepository.save(employee);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
         return String.format("Employee: %s %s noOfHoursMonthly: %d salary: %s",
                 employee.getFirstName(), employee.getLastName(), employee.getNoOfHoursToWork(),
                 currencyInstance.format(calculateSalary(employee.getNoOfHoursToWork())));
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(employeeIdNotFound(employeeId));
    }


    public Employee updateEmployeeDetails(Long employeeId, EmployeeDTO employeeDTO){
        Employee newEmployee = mapEmployeeDTOToEmployee(employeeDTO);
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setNoOfHoursToWork(newEmployee.getNoOfHoursToWork());
                    employee.setAmountPerHour(newEmployee.getAmountPerHour());
                   return employeeRepository.save(newEmployee);
                   }).orElseThrow(employeeIdNotFound(employeeId));
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
