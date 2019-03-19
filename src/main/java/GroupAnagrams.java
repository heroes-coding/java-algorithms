import java.util.Arrays;

public class GroupAnagrams {
    public static void groupAnagrams(String[] a) {
        int n = a.length;
        SortedString[] sorted = new SortedString[n];
        for (int i = 0; i < n; i++) sorted[i] = new SortedString(a[i]);
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));
        int j = 0, x = 0, y = n - 1;
        while (j < n) {
            if (j > 0 && sorted[j].compareTo(sorted[j-1]) == 0) {
                a[x++] = sorted[j].getOriginal();
                a[x++] = sorted[j-1].getOriginal();
                j++;
            } else if (j < n - 1 && sorted[j].compareTo(sorted[j+1]) != 0) {
                a[y--] = sorted[j].getOriginal();
            }
            j++;
        }
        if (j == n) a[x] = sorted[j-1].getOriginal(); // otherwise the last element was already copied
    }


    public static void main(String[] args) {

        String[] a = { "poo", "fart", "hoh", "hof", "hi", "yo", "ih", "oy", "oh", "foh", "stupid"};
        GroupAnagrams.groupAnagrams(a);
        System.out.println(Arrays.toString(a));

    }
}
