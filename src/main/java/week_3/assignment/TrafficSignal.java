import java.util.Scanner;

public class TrafficSignal {

    void simulateTrafficSignal(int cycles) {

        int state = 0;

        for (int i = 0; i < cycles; i++) {

            switch(state) {

                case 0:
                    System.out.print("Red - Stop ");
                    break;

                case 1:
                    System.out.print("Green - Go ");
                    break;

                case 2:
                    System.out.print("Yellow - Prepare to stop ");
                    break;
            }

            state = (state + 1) % 3;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cycles: ");
        int cycles = sc.nextInt();

        TrafficSignal obj = new TrafficSignal();
        obj.simulateTrafficSignal(cycles);

        sc.close();
    }
}