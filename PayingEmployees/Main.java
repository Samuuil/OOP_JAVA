import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new FullTimeEmployee("Galin", 1, 72000),
                new FullTimeEmployee("Preslava", 2, 84000),
                new FullTimeEmployee("Galena", 3, 60000),
                new PartTimeEmployee("ToniStoraro", 4, 25, 120),
                new PartTimeEmployee("Azis", 5, 20, 150),
                new PartTimeEmployee("Lidia", 6, 30, 100)
        );

        System.out.println("Employees with monthly salary > 3000:");
        employees.stream()
                .filter(e -> e.calculateMonthlyPay() > 3000)
                .forEach(e -> System.out.println(e.name + ", Monthly Salary: " + e.calculateMonthlyPay()));

        System.out.println("\nEmployees sorted by descending monthly salary:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::calculateMonthlyPay).reversed())
                .forEach(System.out::println);

        System.out.println("\nEmployee string representations:");
        List<String> employeeStrings = employees.stream()
                .map(Employee::toString)
                .collect(Collectors.toList());
        employeeStrings.forEach(System.out::println);

        DoubleSummaryStatistics stats = employees.stream()
                .mapToDouble(Employee::calculateMonthlyPay)
                .summaryStatistics();

        System.out.println("Average: " + stats.getAverage());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Count: " + stats.getCount());

        System.out.println("Any employee with salary > 6000: " + employees.stream().anyMatch(e -> e.calculateMonthlyPay() > 6000));
        System.out.println("All employees with salary > 2000: " + employees.stream().allMatch(e -> e.calculateMonthlyPay() > 2000));
        System.out.println("No employee with salary < 500: " + employees.stream().noneMatch(e -> e.calculateMonthlyPay() < 500));

        System.out.println("\nMiddle class:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::calculateMonthlyPay).reversed())
                .skip(2)
                .limit(3)
                .forEach(System.out::println);

        double totalSalary = employees.stream()
                .mapToDouble(Employee::calculateMonthlyPay)
                .reduce(0, Double::sum);
        System.out.println("\nTotal Salary (using reduce): " + totalSalary);

        System.out.println("\nGrouping by role:");
        Map<String, List<Employee>> groupedByRole = employees.stream()
                .collect(Collectors.groupingBy(Employee::getRole));
        groupedByRole.forEach((role, empList) -> {
            System.out.println(role + ":");
            empList.forEach(System.out::println);
        });

        System.out.println("\nFinding employee by ID 5:");
        Employee foundEmployee = employees.stream()
                .filter(e -> e.id == 5)
                .findFirst()
                .orElse(employees.get(0));
        System.out.println(foundEmployee);
    }
}