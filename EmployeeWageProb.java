public class EmployeeWageProb {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Problem");
        System.out.println("Check if Employee is present or absent");
        int emp_Present = 1;
        double empCheck = Math.floor(Math.random() * 10) % 2;
        if(empCheck == emp_Present){
            System.out.println("Employee is Present");
        }
        else {
            System.out.println("Employee is Absent");
        }
    }
}