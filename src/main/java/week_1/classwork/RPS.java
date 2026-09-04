package main.java.week_1.classwork;

import java.util.Scanner;
import java.util.Random;

public class RPS {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if (playerMove.equals("Rock") && computerMove.equals("Scissors") ||
            playerMove.equals("Paper") && computerMove.equals("Rock") ||
            playerMove.equals("Scissors") && computerMove.equals("Paper")) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rounds = 5;

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] moves = {"Rock", "Paper", "Scissors"};

        System.out.println("=== Rock Paper Scissors Game ===");

        for (int round = 1; round <= rounds; round++) {

            System.out.print("\nRound " + round + " - Enter Rock, Paper, or Scissors: ");
            String playerMove = sc.next();

            int randomIndex = random.nextInt(3);
            String computerMove = moves[randomIndex];

            String result = playRound(playerMove, computerMove);

            System.out.println("Player: " + playerMove);
            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins")) {
                wins++;
            }
            else if (result.equals("Computer Wins")) {
                losses++;
            }
            else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("\n========== FINAL SUMMARY ==========");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage + "%");

        sc.close();
    }
}