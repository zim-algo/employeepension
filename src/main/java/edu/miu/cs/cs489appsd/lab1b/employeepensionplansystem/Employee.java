package edu.miu.cs.cs489appsd.lab1b.employeepensionplansystem;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private Double yearSalary;

    private PensionPlan pensionPlan;

    public Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, Double yearSalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearSalary = yearSalary;
        this.pensionPlan = pensionPlan;
    }

    public String toJson() {
        String pensionPlanJson = pensionPlan != null ? pensionPlan.toJson() : "null";
        return String.format("{\"employeeId\": \"%d\", \"firstName\": \"%s\", \"lastName\": \"%s\", " +
                        "\"employmentDate\": \"%s\", \"yearSalary\": %.2f, \"pensionPlan\": %s}",
                employeeId, firstName, lastName, employmentDate, yearSalary, pensionPlanJson);
    }
}
