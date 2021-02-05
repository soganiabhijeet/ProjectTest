package dp;

public class DungeonGame {
    /**
     * Let us assume that a 3 x 4 rectangular array has 3 columns and 4 rows and is represented by:
     * <p>
     * boolean landscape[][] = new boolean[3][4];
     * To get the number of rows and columns:
     * <p>
     * int nosRows = landscape[0].length;  // 4
     * int nosCols = landscape.length;     // 3
     *
     * @param args
     */
    public static void main(String[] args) {
        DungeonGame dungeonGame = new DungeonGame();
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(dungeonGame.calculateMinimumHP(dungeon));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        Integer soln = calculateMinimumHPRecur(dungeon, 0, 0, 0);
        if (soln < 0) {
            return Math.abs(soln);
        } else {
            return soln;
        }
    }

    //https://www.youtube.com/watch?v=4uUGxZXoR5o
    private int calculateMinimumHPRecur(int[][] dungeon, int columnIndex, int rowIndex, int totalSoFar) {
        if (rowIndex == dungeon[0].length - 1 && columnIndex == dungeon.length - 1) {
            return totalSoFar + dungeon[columnIndex][rowIndex];
        }
        Integer sol1 = Integer.MIN_VALUE;
        Integer sol2 = Integer.MIN_VALUE;
        if (rowIndex < dungeon[0].length && columnIndex < dungeon.length) {
            //Go bottom
            sol1 = calculateMinimumHPRecur(dungeon, columnIndex, rowIndex + 1,
                    totalSoFar + dungeon[columnIndex][rowIndex]);
        } else {
            return Integer.MIN_VALUE;
        }
        if (columnIndex < dungeon.length && rowIndex < dungeon[0].length) {
            //Go Right
            sol2 = calculateMinimumHPRecur(dungeon, columnIndex + 1, rowIndex,
                    totalSoFar + dungeon[columnIndex][rowIndex]);
        } else {
            return Integer.MIN_VALUE;
        }


        Integer sol = sol1 < sol2 ? sol2 : sol1;
        return sol;
    }
}
