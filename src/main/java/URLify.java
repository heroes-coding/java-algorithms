public class URLify {

    public static String toURL (char[] input, int n) {
        int end = input.length-1;
        int tail = end;
        while(input[tail] == ' ' && tail >= 0) {
            tail--;
        }
        while(tail >= 0) {
            char c = input[tail--];
            if (c == ' ') {
                input[end--] = '0';
                input[end--] = '2';
                input[end--] = '%';
            } else {
                input[end--] = c;
            }
        }
        return new String(java.util.Arrays.copyOfRange(input,end+1,input.length));
    }

    public static void main(String[] args) {
        System.out.println(URLify.toURL("Mr John Smith            ".toCharArray(),13));
    }
}
