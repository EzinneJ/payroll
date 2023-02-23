package com.ezinne.employee;

public interface EmployeeDTOToEmployeeMapper {
    default Employee mapEmployeeDTOToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employee.getLastName());
        employee.setNoOfHoursToWork(employeeDTO.getNoOfHoursToWork());
        employee.setAmountPerHour(employeeDTO.getAmountPerHour());
        return employee;
    }
}
