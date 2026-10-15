
import java.util.*;

class Character {
    private int health;
    private final int maxHealth;

    Character(int maxHealth) {
        this.maxHealth = maxHealth;
        health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health = Math.max(0, health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health = (int) Math.min((long) maxHealth,
                                   (long) health + amount);
        }
    }

    public int getHealth() {
        return health;
    }
}

public class HealthBar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxHealth = sc.nextInt();
        Character c = new Character(maxHealth);

        int damage1 = sc.nextInt();
        c.takeDamage(damage1);
        System.out.println("Health: " + c.getHealth());

        int healing = sc.nextInt();
        c.heal(healing);
        System.out.println("Health: " + c.getHealth());

        int damage2 = sc.nextInt();
        c.takeDamage(damage2);
        System.out.println("Health: " + c.getHealth());

        sc.close();
    }
}
