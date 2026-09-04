import java.util.Scanner;

public class LibraryISBNNormalizer {

    public static String normalizeCode(String raw) {
        return raw.trim().replace(" ", "");
    }

    public static String validateAndFormat(String code) {

        String normalized = normalizeCode(code);

        if (normalized.length() != 13) {
            return "Invalid: publisher code must be 3 letters";
        }

        String publisher = normalized.substring(0, 3);
        String year = normalized.substring(3, 7);
        String digits = normalized.substring(7, 13);

        for (int i = 0; i < publisher.length(); i++) {
            if (!Character.isLetter(publisher.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 0; i < year.length(); i++) {
            if (!Character.isDigit(year.charAt(i))) {
                return "Invalid: year must be 4 digits";
            }
        }

        for (int i = 0; i < digits.length(); i++) {
            if (!Character.isDigit(digits.charAt(i))) {
                return "Invalid: ISBN body must be 6 digits";
            }
        }

        return "[" + publisher.toUpperCase()
                + "] YEAR: " + year
                + " | CATALOG: " + digits;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String code = sc.nextLine();

        System.out.println(validateAndFormat(code));

        sc.close();
    }
}
