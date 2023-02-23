package com.ezinne.employee;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private int noOfHoursToWork;
    private int amountPerHour;

    public Employee(String firstName, String lastName, int noOfHoursToWork, int amountPerHour) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.noOfHoursToWork = noOfHoursToWork;
        this.amountPerHour = amountPerHour;
    }
}
