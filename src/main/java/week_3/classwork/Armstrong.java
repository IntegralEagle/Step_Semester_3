import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        num = sc.nextInt();
        int orignum = num;
        int sum = 0;
        
        while(num != 0){
            int lastdigit = num % 10;
            sum += lastdigit *lastdigit*lastdigit;
            num = num/10;
        }
        if(sum == orignum){
            System.out.println("Armstron number");
        }
        else{
            System.out.println("Not an Armstron number");
        }
        sc.close();
    }
}
