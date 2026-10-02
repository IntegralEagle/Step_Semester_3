public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password == null) {
            return "Invalid";
        }

        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Strength ('abcd'): " + pc1.getStrength()); // Expected: Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Strength ('abcdefgh'): " + pc2.getStrength()); // Expected: Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("Strength ('abcdefghij'): " + pc3.getStrength()); // Expected: Strong
    }
}
