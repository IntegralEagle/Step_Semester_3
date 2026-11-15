import java.util.HashMap;

public class Problem4 {

    static HashMap<String, String> buildLookup(String[][] records) {

        HashMap<String, String> lookup = new HashMap<>();

        for (int i = 0; i < records.length; i++) {

            lookup.put(records[i][0], records[i][1]);
        }

        return lookup;
    }

    static String getDepartment(
            HashMap<String, String> lookup,
            String employeeId) {

        if (lookup.containsKey(employeeId)) {

            return lookup.get(employeeId);
        }

        return "Unknown";
    }

    public static void main(String[] args) {

        String[][] records = {
            {"E245", "Finance"},
            {"E110", "Engineering"},
            {"E390", "Marketing"},
            {"E201", "Engineering"}
        };

        HashMap<String, String> lookup = buildLookup(records);

        System.out.println(
            getDepartment(lookup, "E390")
        );

        System.out.println(
            getDepartment(lookup, "E999")
        );
    }
}