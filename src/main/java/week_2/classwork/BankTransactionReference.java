import java.util.Scanner;

public class BankTransactionReference {

    public static String normalizeReference(String raw) {
        return raw.trim().replace("-", "");
    }

    public static String validateAndFormat(String reference) {

        String normalized = normalizeReference(reference);

        if (normalized.length() != 14) {
            return "Invalid: bank code must be 3 letters";
        }

        String bankCode = normalized.substring(0, 3);
        String date = normalized.substring(3, 9);
        String sequence = normalized.substring(9, 14);

        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 0; i < date.length(); i++) {
            if (!Character.isDigit(date.charAt(i))) {
                return "Invalid: date must be 6 digits";
            }
        }

        for (int i = 0; i < sequence.length(); i++) {
            if (!Character.isDigit(sequence.charAt(i))) {
                return "Invalid: sequence must be 5 digits";
            }
        }

        return "[" + bankCode.toUpperCase() +
                "] DATE: " + date +
                " | SEQ: " + sequence;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String reference = sc.nextLine();

        System.out.println(validateAndFormat(reference));

        sc.close();
    }
}