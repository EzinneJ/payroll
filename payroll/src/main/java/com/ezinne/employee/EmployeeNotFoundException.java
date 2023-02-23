package com.ezinne.employee;

import java.util.function.Supplier;

public interface EmployeeNotFoundException {
    default Supplier<IllegalArgumentException> employeeIdNotFound(Long employeeId) {
        return () -> new IllegalArgumentException(
                String.format("No employee has this id %d", employeeId));
    }
}
