package edu.miu.cs.cs489appsd.lab1b.employeepensionplansystem;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Employee {

    private final Long employeeId;
    private final String firstName;
    private final String lastName;
    private final LocalDate employmentDate;
    private final Double yearSalary;

   private final PensionPlan pensionPlan;

    public Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, Double yearSalary, String planReferenceNumber, LocalDate enrollmentDate, Double monthlyContribution) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearSalary = yearSalary;
        this.pensionPlan = planReferenceNumber == null ? null : new PensionPlan(planReferenceNumber, enrollmentDate, monthlyContribution);
    }
    public Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, Double yearSalary){
       this(employeeId, firstName, lastName, employmentDate, yearSalary, null, null, null);
    }


    public String toJson() {
        String pensionPlanJson = pensionPlan != null ? pensionPlan.toJson() : "null";
        return String.format("\t{\t\n \"employeeId\": \"%d\", \t\n\"firstName\": \"%s\", \t\n\"lastName\": \"%s\"," +
                        "\t\n \"employmentDate\": \"%s\"\t\n, \"yearSalary\": %.2f, \t\n\"pensionPlan\": %s}",
                employeeId, firstName, lastName, employmentDate, yearSalary, pensionPlanJson);
    }

    public Boolean isUpcomingEnrollee (){
        if (pensionPlan != null) return false;

        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        LocalDate nextYear = employmentDate.plusYears(5);
        boolean isEligible = (nextMonth.getMonth() == nextYear.getMonth()) && (LocalDate.now().getYear() == nextYear.getYear());
        return isEligible;
    }
}
