import java.util.Arrays;

public class QuickUnion {

    private int[] ids;

    public QuickUnion(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public int root(int i) {
        while (i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    public void union(int p, int q) {
        ids[root(p)] = root(q);
    }

    @Override
    public String toString() {
        return "QuickUnion{" +
                "ids=" + Arrays.toString(ids) +
                '}';
    }

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        for (int i = 0; i < 7; i++) {
            qu.union(i, i + 2);
            qu.union(i + 1, i + 3);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) continue;
                System.out.println(String.format("%d and %d are connected: %s",i, j, qu.connected(i, j)));
            }
        }
        System.out.println(qu);
    }
}
