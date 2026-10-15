
public class StudentGrade {
    static void findGrade(int marks) {
        char grade;

        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 60) {
            grade = 'C';
        } else if (marks >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Grade " + grade);
    }

    public static void main(String[] args) {
        findGrade(72);
        findGrade(95);
        findGrade(35);
    }
}
