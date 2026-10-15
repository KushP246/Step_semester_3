
import java.util.*;

class Scorecard {
    private final boolean[] results;
    private int count;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        count = 0;
    }

    public void recordAnswer(boolean correct) {
        if (count < results.length) {
            results[count] = correct;
            count++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class ScorecardDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Scorecard s = new Scorecard(n);

        for (int i = 0; i < n; i++) {
            boolean answer = sc.nextBoolean();
            s.recordAnswer(answer);
        }

        System.out.println("Score: " + s.getScore());

        sc.close();
    }
}
