
public class InventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length || sectionA.length == 0) {
            System.out.println("Invalid Inventory Data");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int highest = sectionA[0];
        String section = "A";
        int itemIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > highest) {
                highest = sectionA[i];
                section = "A";
                itemIndex = i;
            }

            if (sectionB[i] > highest) {
                highest = sectionB[i];
                section = "B";
                itemIndex = i;
            }
        }

        String status = totalA == totalB ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highest
                + " (Section " + section + ", Item " + (itemIndex + 1) + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
