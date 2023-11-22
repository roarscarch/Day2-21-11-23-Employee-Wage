public class EmployeeWageProb {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Problem");
        final int empPresentFullTime = 1;// for switch
        final int empPresentPartTime = 2;

        int empHrs = 0;
        int empWage = 0;
        int empWagePerHour = 20;

        for (int i = 0; i < 20; i++) {
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;

            switch (empCheck) {
                case empPresentFullTime:
                    empHrs += 8;
                    break;
                case empPresentPartTime:
                    empHrs += 4;
                    break;
            }
        }

        
        empWage = empHrs * empWagePerHour;
        System.out.println("Emp Hours : " + empHrs);
        System.out.println("Emp Wage : " + empWage);
    }
}
