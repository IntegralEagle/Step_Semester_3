import java.util.HashSet;

public class Problem3 {

    static boolean hasDuplicate(String[] transactionIds) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < transactionIds.length; i++) {

            if (set.contains(transactionIds[i])) {
                return true;
            }

            set.add(transactionIds[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        String[] ids1 = {
            "TXN001", "TXN002", "TXN003",
            "TXN001", "TXN004"
        };

        String[] ids2 = {
            "TXN001", "TXN002", "TXN003"
        };

        System.out.println(hasDuplicate(ids1));

        System.out.println(hasDuplicate(ids2));
    }
}