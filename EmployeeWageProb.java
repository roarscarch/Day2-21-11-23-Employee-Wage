import java.util.Scanner;
import java.util.Random;

public class EmployeeWageCalculator {
    private static final int EMP_PRESENT_FULL_TIME = 1;
    private static final int EMP_PRESENT_PART_TIME = 2;

    public static void computeEmployeeWage(String companyName, int empWagePerHour, int workingDays, int workingHoursPerMonth) {
        int empHrs = 0;
        int empDays = 0;

        while (empHrs < workingHoursPerMonth && empDays < workingDays) {
            int empCheck = generateEmployeeCheck();

            switch (empCheck) {
                case EMP_PRESENT_FULL_TIME:
                    empHrs += 8;
                    empDays += 1;
                    break;
                case EMP_PRESENT_PART_TIME:
                    empHrs += 4;
                    empDays += 1;
                    break;
            }
        }

        int empWage = empHrs * empWagePerHour;
        System.out.println("Company: " + companyName);
        System.out.println("Emp Hours: " + empHrs);
        System.out.println("Emp Days: " + empDays);
        System.out.println("Emp Wage: " + empWage);
        System.out.println("-------------");
    }

    private static int generateEmployeeCheck() {
        Random random = new Random();
        return random.nextInt(3); // Returns 0, 1, or 2
    }

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

        computeEmployeeWage(companyName, empWagePerHour, workingDays, workingHoursPerMonth);

        scanner.close();
    }
}
