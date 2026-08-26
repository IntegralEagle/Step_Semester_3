import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int originalnum = number;
        int reversednum = 0;

        while(number != 0){
            int digit = number % 10;
            reversednum = (reversednum * 10) + digit;
            number = number / 10;
        }
        if(reversednum == originalnum){
            System.out.println("Its a Palindrome");
        }
        else{
            System.out.println("Not a a plaindrome");
        }
        sc.close();
    }
}
