import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for capability
interface TransportUser {
    double TRANSPORT_FEE = 12000.0;
    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

// Abstract Base Class
abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateTuitionAndHostelFee();

    public String getName() {
        return name;
    }

    public double calculateTotalFee() {
        double total = calculateTuitionAndHostelFee();
        if (this instanceof TransportUser) {
            total += ((TransportUser) this).getTransportFee();
        }
        return total;
    }
}

// Subclasses
class DayScholar extends Student implements TransportUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndHostelFee() {
        return 40000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndHostelFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements TransportUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndHostelFee() {
        return 20000.0;
    }
}

public class College {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                students.add(new DayScholar(name));
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                students.add(new Hosteller(name));
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                students.add(new ScholarshipStudent(name));
            }
        }

        double totalCollected = 0.0;
        for (Student student : students) {
            double fee = student.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", student.getName(), fee);
        }

        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}