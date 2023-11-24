import java.util.Random;
import java.util.Scanner;

class EmpWageBuilder {
    private String companyName;
    private int empWagePerHour;
    private int workingDays;
    private int workingHoursPerMonth;
    private int totalEmpWage;

    public EmpWageBuilder(String companyName, int empWagePerHour, int workingDays, int workingHoursPerMonth) {
        this.companyName = companyName;
        this.empWagePerHour = empWagePerHour;
        this.workingDays = workingDays;
        this.workingHoursPerMonth = workingHoursPerMonth;
    }

    private int generateEmployeeCheck() {
        Random random = new Random();
        return random.nextInt(3); // Returns 0, 1, or 2
    }

    public void computeEmployeeWage() {
        int empHrs = 0;
        int empDays = 0;

        while (empHrs < workingHoursPerMonth && empDays < workingDays) {
            int empCheck = generateEmployeeCheck();

            switch (empCheck) {
                case 1:
                    empHrs += 8;
                    empDays += 1;
                    break;
                case 2:
                    empHrs += 4;
                    empDays += 1;
                    break;
                default:
                    empDays += 1;
            }
        }

        totalEmpWage = empHrs * empWagePerHour;
    }

    public void displayEmployeeDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Emp Hours: " + (workingHoursPerMonth < totalEmpWage ? workingHoursPerMonth : totalEmpWage));
        System.out.println("Emp Days: " + (workingDays < empDays ? workingDays : empDays));
        System.out.println("Emp Wage: " + totalEmpWage);
        System.out.println("-------------");
    }
}

public class EmployeeWageCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Problem");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Company Name: ");
        String companyName = scanner.nextLine();

        System.out.print("Enter Wage Per Hour: ");
        int empWagePerHour = scanner.nextInt();

        System.out.print("Enter Working Days: ");
        int workingDays = scanner.nextInt();

        System.out.print("Enter Working Hours Per Month: ");
        int workingHoursPerMonth = scanner.nextInt();

        EmpWageBuilder empWageBuilder = new EmpWageBuilder(companyName, empWagePerHour, workingDays, workingHoursPerMonth);
        empWageBuilder.computeEmployeeWage();
        empWageBuilder.displayEmployeeDetails();

        scanner.close();
    }
}
