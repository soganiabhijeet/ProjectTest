package backtracking;

public class NQueenProblem {
    final int N = 4;

    public static void main(String args[]) {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }

    /* This function solves the N Queen problem using
      Backtracking.  It mainly uses solveNQUtil () to
      solve the problem. It returns false if queens
      cannot be placed, otherwise, return true and
      prints placement of queens in the form of 1s.
      Please note that there may be more than one
      solutions, this function prints one of the
      feasible solutions.*/
    boolean solveNQ() {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    private boolean solveNQUtil(int[][] board, int col) {
        if (col == N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1)) {
                    return true;
                }
                else {
                    board[i][col] = 0;
                }
            }

        }
        return false;
    }

    /* A utility function to check if a queen can
      be placed on board[row][col]. Note that this
      function is called when "col" queens are already
      placeed in columns from 0 to col -1. So we need
      to check only left side for attacking queens */
    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    /* A utility function to print solution */
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

}
