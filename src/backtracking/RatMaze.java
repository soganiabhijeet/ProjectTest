package backtracking;

public class RatMaze {

    // Size of the maze
    static int N;

    /* A utility function to print solution matrix
    sol[N][N] */
    void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    /* A utility function to check if x, y is valid
        index for N*N maze */
    boolean isSafe(int maze[][], int x, int y) {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    public static void main(String args[]) {
        RatMaze rat = new RatMaze();
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        N = maze.length;
        rat.solveMaze(maze);
    }

    private boolean doesPathExist(int[][] maze, int horizontal, int vertical, int[][] sol) {
        if (horizontal == (N - 1) && vertical == (N - 1)) {
            sol[horizontal][vertical] = 1;
            return true;
        }
        if (isSafe(maze, horizontal, vertical)) {
            sol[horizontal][vertical] = 1;
            if (doesPathExist(maze, horizontal + 1, vertical, sol)) {
                return true;
            }
            if (doesPathExist(maze, horizontal, vertical + 1, sol)) {
                return true;
            }
            sol[horizontal][vertical] = 0;
        }
        return false;
    }

    private void solveMaze(int[][] maze) {
        int sol[][] = new int[N][N];
        if (doesPathExist(maze, 0, 0, sol)) {
            printSolution(sol);
        }
    }
}
