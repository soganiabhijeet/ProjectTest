package backtracking;

public class MatrixTraversal {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int mat[][] = {{1, 2, 3},
                {4, 5, 6}};
        int maxLengthOfPath = m + n - 1;
        printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);
    }

    private static void printMatrix(int[][] mat, int m, int n, int horizontal, int vertical, int[] path, int index) {
        if (horizontal < m && vertical < n) {
            path[index] = mat[horizontal][vertical];
            if (horizontal == (m - 1) && vertical == (n - 1)) {
                for (int l = 0; l <= index; l++)
                {
                    System.out.print(path[l] + " ");
                }
                System.out.println();
            }
            printMatrix(mat, m, n, horizontal + 1, vertical, path, index + 1);
            printMatrix(mat, m, n, horizontal, vertical + 1, path, index + 1);
        }
    }
}
