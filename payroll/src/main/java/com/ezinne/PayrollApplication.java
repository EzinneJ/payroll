package com.ezinne;

import com.ezinne.employee.Employee;
import com.ezinne.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class PayrollApplication {

    private final EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Employee employee = new Employee("Joy", "Ezinne", 160, 10);
            employeeRepository.save(employee);
            Employee employee1 = new Employee("Grace", "Solo", 140, 9);
            employeeRepository.save(employee1);

        };

    }


}
