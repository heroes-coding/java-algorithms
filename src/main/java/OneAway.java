public class OneAway {
    public static boolean isOA(String x, String y) {
        if (y.length() > x.length()) {
            String temp = x;
            x = y;
            y = temp;
        }
        char[] xChars = x.toCharArray();
        char[] yChars = y.toCharArray();
        int differences = 0;
        int m = x.length();
        int n = y.length();
        if (m - n > 1) return false;
        boolean isSubstitution = m == n;
        int i = 0;
        int j = 0;
        while (i < m) {
            char a = xChars[i++];
            char b = yChars[j++];
            if (a == b) continue;
            else {
                differences++;
                if (!isSubstitution) j--;
            }
        }
        System.out.println(differences);
        return differences <= 1;
    }
    public static void main(String[] args) {
        String x = "AABBCA";
        String y = "AABBACAAAAA";
        System.out.println(
                String.format("String %s and String %s are just one edit apart: %b", x, y, OneAway.isOA(x,y))
        );
    }

}
