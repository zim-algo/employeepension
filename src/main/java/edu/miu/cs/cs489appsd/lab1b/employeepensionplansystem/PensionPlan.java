package edu.miu.cs.cs489appsd.lab1b.employeepensionplansystem;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PensionPlan {
    private final String planReferenceNumber;
    private final LocalDate enrollmentDate;
    private final Double monthlyContribution;

    public String toJson() {
        return String.format("{\"planReferenceNumber\": \"%s\", \"enrollmentDate\": \"%s\", " +
                        "\"monthlyContribution\": %.2f}",
                planReferenceNumber, enrollmentDate, monthlyContribution);
    }

}
