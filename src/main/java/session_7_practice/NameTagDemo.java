
import java.util.*;

final class NameTag {
    private final String firstName;
    private final String lastName;

    NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        firstName = parts[0];
        lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class NameTagDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fullName = sc.nextLine();

        NameTag tag = new NameTag(fullName);

        System.out.println("Nickname: " + tag.getNickname());

        sc.close();
    }
}
