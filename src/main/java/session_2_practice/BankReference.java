
public class BankReference {
    static String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference;
        }

        return reference.substring(0, 3).toUpperCase() + reference.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (reference.charAt(i) < '0' || reference.charAt(i) > '9') {
                return "Invalid: remaining 11 characters must be digits";
            }
        }

        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(reference.substring(0, 3))
              .append("] DATE: ")
              .append(reference.substring(3, 5))
              .append("/")
              .append(reference.substring(5, 7))
              .append("/")
              .append(reference.substring(7, 9))
              .append(" | SEQ: ")
              .append(reference.substring(9, 14));

        return result.toString();
    }

    public static void main(String[] args) {
        String ref1 = " hdf03022600042 ";
        String ref2 = "12F03022600042";

        System.out.println(validateAndFormat(normalizeReference(ref1)));
        System.out.println(validateAndFormat(normalizeReference(ref2)));
    }
}
