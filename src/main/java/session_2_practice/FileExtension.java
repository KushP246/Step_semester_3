
public class FileExtension {
    static String validateFileExtension(String filename) {
        int index = filename.lastIndexOf('.');

        if (index == -1 || index == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(index + 1);

        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
