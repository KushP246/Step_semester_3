
import java.util.*;

class Cart {
    private double[] prices;
    private int count;
    private final String cartId;

    Cart(String cartId, int size) {
        this.cartId = cartId;
        prices = new double[size];
        count = 0;
    }

    public void addItem(double price) {
        if (count < prices.length && price >= 0) {
            prices[count] = price;
            count++;
        }
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = sc.next();
        int size = sc.nextInt();
        int n = sc.nextInt();

        Cart cart = new Cart(id, size);

        for (int i = 0; i < n; i++) {
            double price = sc.nextDouble();
            cart.addItem(price);
        }

        System.out.printf("Total: %.2f%n", cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());

        sc.close();
    }
}
