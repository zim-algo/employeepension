package edu.miu.cs.cs489appsd.lab1b.employeepensionplansystem;

import lombok.var;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        List<Employee> employees = new ArrayList<>();

        // Create PensionPlan objects and add them to Employees
        PensionPlan pensionPlan1 = new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.00);
        employees.add(new Employee(991L, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50, pensionPlan1));

        // Employee without a PensionPlan
        employees.add(new Employee(992L, "Bernard", "Shaw", LocalDate.of(2019, 4, 3), 197750.00, null));

        PensionPlan pensionPlan2 = new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50);
        employees.add(new Employee(993L, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75, pensionPlan2));

        // Employee without a PensionPlan
        employees.add(new Employee(994L, "Wesley", "Schneider", LocalDate.of(2019, 5, 2), 74500.00, null));


        printAllEmployeesSorted(employees);
        printEmployeesEligibleForPensionNextMonth(employees);


    }

    private static void printAllEmployeesSorted(List<Employee> employees) {
        String jsonAllEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getYearSalary, Comparator.reverseOrder()))
                .map(Employee::toJson)
                .collect(Collectors.joining(",\n", "[\n", "\n]"));

        System.out.println("All Employees Sorted by Last Name and Salary:\n" + jsonAllEmployees);
    }

    private static void printEmployeesEligibleForPensionNextMonth(List<Employee> employees) {
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        LocalDate startOfNextMonth = nextMonth.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endOfNextMonth = nextMonth.with(TemporalAdjusters.lastDayOfMonth());

        String jsonUpcomingEnrollees = employees.stream()
                .filter(e -> e.getPensionPlan() == null ||
                        (e.getPensionPlan().getEnrollmentDate().isAfter(startOfNextMonth) &&
                                e.getPensionPlan().getEnrollmentDate().isBefore(endOfNextMonth)))
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .map(Employee::toJson)
                .collect(Collectors.joining(",\n", "[\n", "\n]"));

        System.out.println("Employees Eligible for Pension Next Month:\n" + jsonUpcomingEnrollees);
    }
}
