import java.util.Random;

public class EmployeeWageCalculator {
    private static final int EMP_PRESENT_FULL_TIME = 1;
    private static final int EMP_PRESENT_PART_TIME = 2;

    private int empHrs;
    private int empWagePerHour;
    private int empDays;

    public EmployeeWageCalculator(int empWagePerHour) {
        this.empWagePerHour = empWagePerHour;
    }

    private int generateEmployeeCheck() {
        Random random = new Random();
        return random.nextInt(3); // Returns 0, 1, or 2
    }

    public void computeEmployeeWage() {
        while (empHrs < 100 && empDays < 20) {
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
    }

    public void displayEmployeeDetails() {
        int empWage = empHrs * empWagePerHour;
        System.out.println("Emp Hours: " + empHrs);
        System.out.println("Emp Days: " + empDays);
        System.out.println("Emp Wage: " + empWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Problem");

        EmployeeWageCalculator calculator = new EmployeeWageCalculator(20);
        calculator.computeEmployeeWage();
        calculator.displayEmployeeDetails();
    }
}
