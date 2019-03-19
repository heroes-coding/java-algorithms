import java.util.Arrays;

public class SortedString implements Comparable<SortedString> {
    String original;
    String sorted;
    public SortedString(String original) {
        this.original = original;
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        this.sorted = new String(chars);
    }
    public int compareTo(SortedString other) {
        return this.sorted.compareTo(other.sorted);
    }
    public String getOriginal() { return original; }
    public String toString() { return sorted; }
}