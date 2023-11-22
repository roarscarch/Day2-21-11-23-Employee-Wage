public class EmployeeWageProb {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Problem");
        System.out.println("Check if Employee is present or absent");

        final int empPresentFullTime = 1;
        final int empPresentPartTime = 2;

        int empHrs = 0;
        int empWage = 0;
        int empWagePerHour = 20;

        int empCheck = (int) Math.floor(Math.random() * 10) % 3;

        switch (empCheck) {// in java , in switch u can only add constant expressions , and final = const in java
            case empPresentFullTime:
                System.out.println("Employee is present Full Time:");
                empHrs = 8;
                break;
            case empPresentPartTime:
                System.out.println("Employee is Doing Part Time:");
                empHrs = 4;
                break;
            default:
                System.out.println("Employee is Absent:");
                empHrs = 0;
                break;
        }

        // Calculation and print statements outside the switch
        empWage = empHrs * empWagePerHour;
        System.out.println("Emp Hours : " + empHrs);
        System.out.println("Emp Wage : " + empWage);
    }
}
