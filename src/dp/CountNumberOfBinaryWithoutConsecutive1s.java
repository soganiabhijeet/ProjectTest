package dp;

public class CountNumberOfBinaryWithoutConsecutive1s {
    //https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/

    public static void main(String args[]) {
        CountNumberOfBinaryWithoutConsecutive1s cnb = new CountNumberOfBinaryWithoutConsecutive1s();
        System.out.println(cnb.count(4));
    }

    public int count(int n) {
        int a[] = new int[n];
        int b[] = new int[n];

        a[0] = 1;
        b[0] = 1;

        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        return a[n - 1] + b[n - 1];
    }
}
