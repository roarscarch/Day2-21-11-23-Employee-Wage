public class EmployeeWageProb {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Problem");
        System.out.println("Check if Employee is present or absent");
        int emp_Present = 1;
        double empCheck = Math.floor(Math.random() * 10) % 2;
        int emp_wage_per_hour = 20;

        int empHrs;
        int empWage;
        double empCheck = Math.floor(Math.random() * 10) % 2;
        if(empCheck == emp_Present){
            System.out.println("Employee is Present");
            empHrs = 8;
        }
        else {
            System.out.println("Employee is Absent");
            empHrs = 0;
        }
        //calculation
        empWage = empHrs * EMP_WAGE_PER_HOUR;
        System.out.println("Emp Hours : "+empHrs);
        System.out.println("Emp Wage : "+empWage);
    }
}