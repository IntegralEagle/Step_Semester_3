
import java.util.Scanner;

class Staff {

    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    double getTotal() {
        return baseSalary + getBonus();
    }

    void display() {
        System.out.printf("%s (Staff): base %.1f, bonus %.1f, total %.1f%n",
                name, baseSalary, getBonus(), getTotal());
    }
}

class Teacher extends Staff {

    Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 5000;
    }

    @Override
    void display() {
        System.out.printf("%s (Teacher): base %.1f, bonus %.1f, total %.1f%n",
                name, baseSalary, getBonus(), getTotal());
    }
}

class LabAssistant extends Staff {

    LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 2000;
    }

    @Override
    void display() {
        System.out.printf("%s (LabAssistant): base %.1f, bonus %.1f, total %.1f%n",
                name, baseSalary, getBonus(), getTotal());
    }
}

public class Problem1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of staff: ");
        int n = sc.nextInt();

        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equalsIgnoreCase("Teacher")) {
                staff[i] = new Teacher(name, salary);
            }
            else if (type.equalsIgnoreCase("LabAssistant")) {
                staff[i] = new LabAssistant(name, salary);
            }
            else {
                staff[i] = new Staff(name, salary);
            }
        }

        double grandTotal = 0;

        System.out.println("\nStaff Salary Details:");

        for (int i = 0; i < n; i++) {

            staff[i].display();

            grandTotal += staff[i].getTotal();
        }

        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);

        sc.close();
    }
}

