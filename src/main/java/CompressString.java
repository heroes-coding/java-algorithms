
public class CompressString {

    private static void appendSB(StringBuilder sb, char chr, int count) {
        sb.append(chr);
        sb.append(count);
    }
    public static String compress(String input) {

        if (input == null) return null;
        StringBuilder compString = new StringBuilder();
        char curChar = input.charAt(0);
        int count = 1;
        for (int c = 1; c < input.length(); c++) {
            char nextChar = input.charAt(c);
            if (curChar != nextChar) {
                appendSB(compString, curChar, count);
                curChar = nextChar;
                count = 0;
            }
            count++;
        }
        appendSB(compString, curChar, count);
        return input.length() <= compString.length() ? input : compString.toString();
    }

    public static void main(String[] args) {
        System.out.println(CompressString.compress("AAA"));
    }

}
