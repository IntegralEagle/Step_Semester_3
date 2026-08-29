import java.util.Scan_ner;
public class Classify {
    void classifyNumber(int number){
        if(number > 0){
            System.out.println("Positive Number");
        }
        else if(number == 0){
            System.out.println("Exactly zero");
        }
        else{
            System.out.println("Negative number");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = sc.nextInt();

        P2 obj = new P2();
        obj.classifyNumber(number);
        sc.close();
    }
}
