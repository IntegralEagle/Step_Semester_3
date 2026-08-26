import java.util.Scanner;
public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1, number2, remainder;

        number1 = sc.nextInt();
        number2 = sc.nextInt();
        
        while(number2 != 0){
            remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }
        System.out.println("The GCD is: " + number1);
        sc.close();
    }
}
