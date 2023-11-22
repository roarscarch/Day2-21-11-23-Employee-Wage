public class EmployeeWageProb {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Problem");
        System.out.println("Check if Employee is present or absent");
        int emp_Present_FullTime = 1;
        int emp_Present_PartTime= 2;

        int empHrs =0;
        int empWage =0;
        int emp_wage_per_hour = 20;
        
        
        double empCheck = Math.floor(Math.random() * 10) % 3;
       
        if(empCheck == emp_Present_FullTime){
            System.out.println("Employee is Present");
            empHrs = 8;
        }
        else if(empCheck == emp_Present_PartTime) {
            System.out.println("Employee is Halftime");
            empHrs = 4;
        }
        else{
            System.out.println("Employee is Absent");
            empHrs =0;
        }
        //calculation
        empWage = empHrs * emp_wage_per_hour;
        System.out.println("Emp Hours : "+empHrs);
        System.out.println("Emp Wage : "+empWage);
    }
}


