
import java.util.*;
import java.util.regex.*;

abstract class Question {
    String correctAnswer, studentAnswer;
    int points;

    Question(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {
    MCQ(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class TF extends Question {
    TF(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();
        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2)
            return points * 0.75;
        if (count == 1)
            return points * 0.50;

        return 0;
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        Map<String, java.util.function.Function<List<String>, Question>> types =
            new HashMap<>();

        types.put("MCQ",
            a -> new MCQ(a.get(1), a.get(2), Integer.parseInt(a.get(3))));

        types.put("TF",
            a -> new TF(a.get(1), a.get(2), Integer.parseInt(a.get(3))));

        types.put("ESSAY",
            a -> new Essay(a.get(1), a.get(2), Integer.parseInt(a.get(3))));

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|\\S+");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            List<String> values = new ArrayList<>();

            while (matcher.find()) {
                values.add(matcher.group(1) != null
                    ? matcher.group(1) : matcher.group());
            }

            String type = values.get(0);
            List<String> answers = values.subList(2, 5);

            Question q = types.get(type).apply(answers);
            double score = q.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
