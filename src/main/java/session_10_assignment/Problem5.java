
public class Problem5 {
    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > highest) {
                second = highest;
                highest = scores[i];
            } else if (scores[i] > second && scores[i] != highest) {
                second = scores[i];
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] scores1 = {45, 78, 92, 78, 60};
        int[] scores2 = {50, 50, 50};

        System.out.println(secondHighest(scores1));
        System.out.println(secondHighest(scores2));
    }
}
