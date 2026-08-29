import java.util.Scanner;
public class gradeClassifier {
    void classifywithAttendance(int marks, int attendance){
        if(attendance < 70 && marks < 40){
            System.out.println("Detained");
        }
        else if(marks >= 90){
            System.out.println("Grade : A");
        }
        else if(marks >= 75 && marks <= 89){
            System.out.println("Grade : B");
        }
        else if(marks >= 60 && marks <= 74){
            System.out.println("Grade : C");
        }
        else if(marks >= 40 && marks <= 59){
            System.out.println("Grade : D");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Attendance: ");
        int attendance = sc.nextInt();
        System.out.println("Enter Marks: ");
        int marks = sc.nextInt();
        gradeClassifier g = new gradeClassifier();
        g.classifywithAttendance(marks, attendance);
        sc.close();
    }
}
