public class AddLinkedLists {


    public static int addLinkedLists(Node p, Node q) {
        int power = 0;
        int sum = 0;
        while (p != null && q != null) {
            if (p != null) {
                sum += p.data*(int)Math.pow(10,power);
                p = p.next;
            }
            if (q != null) {
                sum += q.data*(int)Math.pow(10,power);
                q = q.next;
            }
            System.out.println(sum);
            power++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] p = {2, 3, 4};

        Node head = new Node(1,null);
        Node head2 = new Node(5, null);
        for (int i: p) {
            Node newNode = new Node(i,head);
            head = newNode;
            Node newNode2 = new Node(i*2,head2);
            head2 = newNode2;
        }

        Node one = head;
        Node two = head2;
        while (one != null) {
            System.out.println(one.data);
            System.out.println(two.data);
            one = one.next;
            two = two.next;
        }

        System.out.println(AddLinkedLists.addLinkedLists(head,head2));



    }

}
