package main.java.week_6.assignment;
class EmployeeCompany {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompany(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println("Company: " + companyName);
        System.out.println("Total Employees: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeCompany emp1 = new EmployeeCompany("Alice", 50000);
        EmployeeCompany emp2 = new EmployeeCompany("Bob", 60000);
        EmployeeCompany emp3 = new EmployeeCompany("Charlie", 55000);

        // Called using the Class name, not individual objects
        EmployeeCompany.printCompanyInfo();
    }
}