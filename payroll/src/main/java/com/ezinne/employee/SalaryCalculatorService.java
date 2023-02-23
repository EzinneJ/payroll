package com.ezinne.employee;

import java.math.BigDecimal;

public interface SalaryCalculatorService {

    default BigDecimal calculateSalary(int noOfHoursWorked) {
        int amountPerHour = 500;
        return BigDecimal.valueOf(Math.multiplyExact(noOfHoursWorked, amountPerHour));
    }
}
