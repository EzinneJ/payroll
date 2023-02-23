package com.ezinne.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private int noOfHoursToWork;
    private int amountPerHour;
}
