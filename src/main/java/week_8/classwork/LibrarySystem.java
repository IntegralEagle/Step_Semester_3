import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getBorrowDays();

    public String calculateDueDate(LocalDate baseDate) {
        LocalDate dueDate = baseDate.plusDays(getBorrowDays());
        return dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getBorrowDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public int getBorrowDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getBorrowDays() {
        return 3;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate baseDate = LocalDate.parse("2023-10-26");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ", 2);
            String itemType = parts[0];
            String title = parts.length > 1 ? parts[1].replace("\"", "").trim() : "";

            LibraryItem item;
            switch (itemType) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title);
                    break;
                default:
                    continue;
            }

            System.out.println(item.getTitle() + ": " + item.calculateDueDate(baseDate));
        }

        sc.close();
    }
}