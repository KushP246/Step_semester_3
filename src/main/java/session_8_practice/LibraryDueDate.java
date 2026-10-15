
import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;
    LocalDate issueDate;

    LibraryItem(String title, LocalDate issueDate) {
        this.title = title;
        this.issueDate = issueDate;
    }

    abstract LocalDate calculateDueDate();
}

class Book extends LibraryItem {
    Book(String title, LocalDate issueDate) {
        super(title, issueDate);
    }

    LocalDate calculateDueDate() {
        return issueDate.plusDays(14);
    }
}

class DVD extends LibraryItem {
    DVD(String title, LocalDate issueDate) {
        super(title, issueDate);
    }

    LocalDate calculateDueDate() {
        return issueDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, LocalDate issueDate) {
        super(title, issueDate);
    }

    LocalDate calculateDueDate() {
        return issueDate.plusDays(3);
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        Map<String, java.util.function.BiFunction<String, LocalDate, LibraryItem>> types =
            new HashMap<>();

        types.put("BOOK", Book::new);
        types.put("DVD", DVD::new);
        types.put("MAGAZINE", Magazine::new);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            title = title.substring(1, title.length() - 1);

            LibraryItem item = types.get(type).apply(title, currentDate);

            System.out.println(item.title + ": " + item.calculateDueDate());
        }

        sc.close();
    }
}
