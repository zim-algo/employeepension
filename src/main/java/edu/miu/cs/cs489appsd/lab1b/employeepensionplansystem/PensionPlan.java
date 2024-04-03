package edu.miu.cs.cs489appsd.lab1b.employeepensionplansystem;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private Double monthlyContribution;

    public PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, Double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    public String toJson() {
        return String.format("{\"planReferenceNumber\": \"%s\", \"enrollmentDate\": \"%s\", " +
                        "\"monthlyContribution\": %.2f}",
                planReferenceNumber, enrollmentDate, monthlyContribution);
    }

}
