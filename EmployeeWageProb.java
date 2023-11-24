import java.util.Random;
import java.util.Scanner;

class CompanyEmpWage {
    public String companyName;
    public int empWagePerHour;
    public int workingDays;
    public int workingHoursPerMonth;
    public int totalEmpWage;

    public CompanyEmpWage(String companyName, int empWagePerHour, int workingDays, int workingHoursPerMonth) {
        this.companyName = companyName;
        this.empWagePerHour = empWagePerHour;
        this.workingDays = workingDays;
        this.workingHoursPerMonth = workingHoursPerMonth;
    }
}

class EmpWageBuilder {
    private CompanyEmpWage[] companyEmpWages;
    private int numCompanies;

    public EmpWageBuilder() {
        companyEmpWages = new CompanyEmpWage[5]; // Assuming a maximum of 5 companies, you can adjust as needed
        numCompanies = 0;
    }

    public void addCompanyEmpWage(String companyName, int empWagePerHour, int workingDays, int workingHoursPerMonth) {
        companyEmpWages[numCompanies] = new CompanyEmpWage(companyName, empWagePerHour, workingDays, workingHoursPerMonth);
        numCompanies++;
    }

    private int generateEmployeeCheck() {
        Random random = new Random();
        return random.nextInt(3); // Returns 0, 1, or 2
    }

    public void computeEmployeeWage() {
        for (int i = 0; i < numCompanies; i++) {
            int empHrs = 0;
            int empDays = 0;

            while (empHrs < companyEmpWages[i].workingHoursPerMonth && empDays < companyEmpWages[i].workingDays) {
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

            companyEmpWages[i].totalEmpWage = empHrs * companyEmpWages[i].empWagePerHour;
        }
    }

    public void displayEmployeeDetails() {
        for (int i = 0; i < numCompanies; i++) {
            System.out.println("Company: " + companyEmpWages[i].companyName);
            System.out.println("Emp Hours: " + (companyEmpWages[i].workingHoursPerMonth < companyEmpWages[i].totalEmpWage ? companyEmpWages[i].workingHoursPerMonth : companyEmpWages[i].totalEmpWage));
            System.out.println("Emp Days: " + (companyEmpWages[i].workingDays < companyEmpWages[i].totalEmpWage ? companyEmpWages[i].workingDays : companyEmpWages[i].totalEmpWage));
            System.out.println("Emp Wage: " + companyEmpWages[i].totalEmpWage);
            System.out.println("-------------");
        }
    }
}

public class EmployeeWageCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Problem");

        Scanner scanner = new Scanner(System.in);

        EmpWageBuilder empWageBuilder = new EmpWageBuilder();

        // Adding companies
        empWageBuilder.addCompanyEmpWage("Company A", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Company B", 25, 22, 120);
        // Add more companies as needed

        empWageBuilder.computeEmployeeWage();
        empWageBuilder.displayEmployeeDetails();

        scanner.close();
    }
}
