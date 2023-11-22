public class EmployeeWageProb {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Problem");

        final int empPresentFullTime = 1;
        final int empPresentPartTime = 2;

        int empHrs = 0;
        int empWage = 0;
        int empWagePerHour = 20;
        int empDays = 0;

        while (empHrs < 100 && empDays < 20) {
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;

            switch (empCheck) {
                case empPresentFullTime:
                    empHrs += 8;
                    empDays += 1;
                    break;
                case empPresentPartTime:
                    empHrs += 4;
                    empDays += 1;
                    break;
            }
        }

        empWage = empHrs * empWagePerHour;
        System.out.println("Emp Hours : " + empHrs);
        System.out.println("Emp Days : " + empDays);
        System.out.println("Emp Wage : " + empWage);
    }
}
