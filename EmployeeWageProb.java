import java.util.Random;

interface IEmployeeWageComputation {
    int PART_TIME = 1;
    int FULL_TIME = 2;

    void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

    void calculateTotalWage();
}

class CompanyEmpWage {
    final String COMPANY_NAME;
    final int WAGE_PER_HR;
    final int MAX_WORKING_DAYS;
    final int MAX_WORKING_HRS;
    int totalEmpWage;

    CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        COMPANY_NAME = companyName;
        WAGE_PER_HR = wagePerHr;
        MAX_WORKING_DAYS = maxWorkingDays;
        MAX_WORKING_HRS = maxWorkingHrs;
        totalEmpWage = 0;
    }

    void setTotalEmployeeWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Details of ").append(COMPANY_NAME).append(" employee\n");
        result.append("-----------------------------------------------------\n");
        result.append("Wage per hour:").append(WAGE_PER_HR).append("\n");
        result.append("Maximum working days:").append(MAX_WORKING_DAYS).append("\n");
        result.append("Maximum working hours:").append(MAX_WORKING_HRS).append("\n");
        return "Total wage for a month of " + COMPANY_NAME + " employee is " + totalEmpWage + "\n";
    }
}

class EmployeeWageProb implements IEmployeeWageComputation {
    private static final Random random = new Random();
    private int noOfCompanies, index;
    private CompanyEmpWage[] companies;

    public EmployeeWageProb(int noOfCompanies) {
        this.noOfCompanies = noOfCompanies;
        this.companies = new CompanyEmpWage[noOfCompanies];
        this.index = 0;
    }

    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        companies[index++] = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
    }

    int generateEmployeeType() {
        return random.nextInt(3);
    }

    int getWorkingHrs(int empType) {
        switch (empType) {
            case FULL_TIME:
                return 8;
            case PART_TIME:
                return 4;
            default:
                return 0;
        }
    }

    void printDetails(int day, int workingHrs, int wage, int totalWorkingHrs) {
        System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
    }

    public void calculateTotalWage() {
        for (CompanyEmpWage company : companies) {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company);
        }
    }

    int calculateTotalWage(CompanyEmpWage companyEmpWage) {
        System.out.println("Computation of total wage of " + companyEmpWage.COMPANY_NAME + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                && totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
            totalWage += wage;
            printDetails(day, workingHrs, wage, totalWorkingHrs);
        }
        return totalWage;
    }

    public static void main(String args[]) {
        EmployeeWageProb employeeWageProb = new EmployeeWageProb(3);
        employeeWageProb.addCompany("Microsoft", 4, 30, 100);
        employeeWageProb.addCompany("Google", 5, 40, 170);
        employeeWageProb.addCompany("Apple", 9, 10, 70);
        employeeWageProb.calculateTotalWage();
    }
}
