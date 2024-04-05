package edu.miu.cs.cs489appsd.lab1b.employeepensionplansystem;

import lombok.var;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

        employees.add(new Employee(991L, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50, "EX1089", LocalDate.of(2023, 1, 17), 100.00));

        employees.add(new Employee(992L, "Bernard", "Shaw", LocalDate.of(2019, 4, 3), 197750.00));

        employees.add(new Employee(993L, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75, "SM2307", LocalDate.of(2019, 11, 4), 1555.50));

        employees.add(new Employee(994L, "Wesley", "Schneider", LocalDate.of(2019, 5, 2), 74500.00));


        printAllEmployeesSorted(employees);
        printEmployeesEligibleForPensionNextMonth(employees);


    }

    private static void printAllEmployeesSorted(List<Employee> employees) {
        var jsonAllEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getYearSalary, Comparator.reverseOrder()))
                .map(Employee::toJson)
                .toArray();
        printJsonFormat(jsonAllEmployees);
    }

    private static void printEmployeesEligibleForPensionNextMonth(List<Employee> employees) {


        var jsonUpcomingEnrollees = employees.stream()
                .filter(Employee::isUpcomingEnrollee)
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .map(Employee::toJson)
                .toArray();

        printJsonFormat(jsonUpcomingEnrollees);
    }

    public static void printJsonFormat(Object [] result){
        System.out.println("[");
        Arrays.stream(result).forEach(System.out::println);
        System.out.println("]");
    }
}
