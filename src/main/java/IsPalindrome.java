public class IsPalindrome {

    public static boolean isPP(String input) {
        int[] charCounts = new int[128];
        for (char c: input.toCharArray()) {
            charCounts[c-'A']++;
        }
        int oddCount = 0;
        boolean isOdd = input.length() % 2 == 1;
        for (int count: charCounts) {
            if (count%2 == 1) {
                oddCount++;
            }
        }
        if (isOdd && oddCount > 1) return false;
        else if (!isOdd && oddCount > 0) return false;
        return true;
    }

    public static void main(String[] args) {
        String input = "AABBCA";
        System.out.println(
                String.format("%s can be rearranged into a palindrome: %b", input, IsPalindrome.isPP(input))
                );
    }
}
