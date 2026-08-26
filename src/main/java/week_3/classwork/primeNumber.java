import java.util.Scanner;
public class primeNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        boolean isprime = true;
        if(number < 2){
            isprime = false;
        }
        else{
            for(int i = 2; i < number; i++){
                if(number % i == 0){
                    isprime = false;
                    break;
                }
            }
        }
        System.out.println("The given  umber is prime");
        sc.close();
    }
}
