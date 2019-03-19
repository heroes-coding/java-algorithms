import java.util.Arrays;

public class SortedMerge implements Comparable<SortedMerge> {
    public int compareTo(SortedMerge other) {
        return -1;
    }
    public static void merge(Comparable[] a, Comparable[] b) {
        int i = 0, j = 0, n = b.length;
        while (j < n) {
            if (a[i] == null) a[i++] = b[j++];
            else if (a[i].compareTo(b[j]) < 0) i++;
            else {
                Comparable temp = a[i];
                a[i] = b[j];
                int k = j;
                while (++k < n) {
                    if (temp.compareTo(b[k]) > 0) {
                        b[k-1] = b[k];
                    } else break;
                }
                b[k-1] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {

        String hi = "hia";
        char[] his = hi.toCharArray();
        Arrays.sort(his);
        System.out.println(new String(his));
        Integer[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 11, null, null, null, null, null, null, null, null, null, null, null};
        Integer[] b = { -100, 0, 2, 3, 4, 5, 6, 6, 7, 8, 10};
        SortedMerge.merge(a,b);
        System.out.println(Arrays.toString(a));
    }
}
