
import java.util.*;

class TrafficLight {
    private String color;
    private final String id;

    TrafficLight(String id) {
        this.id = id;
        color = "RED";
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }
}

public class TrafficLightDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = sc.next();
        int n = sc.nextInt();

        TrafficLight t = new TrafficLight(id);

        System.out.println(t.getColor());

        for (int i = 0; i < n; i++) {
            t.next();
            System.out.println(t.getColor());
        }

        sc.close();
    }
}
