package dp;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    int totalNum = 0;
    int[][] totalToValues;


    public static void main(String args[]) {
        CoinChange cc = new CoinChange();
        int total = 500;
        int[] coins = {1, 2, 5};
        cc.totalToValues = new int[total+1][coins.length];
        for (int i = 0; i <= total; i++) {
            for (int j = 0; j < coins.length; j++) {
                cc.totalToValues[i][j] = -1;
            }
        }


        //cc.numberOfSolutionsRecur(total, coins, 0);
        System.out.println("Recur" + cc.numberOfSolutionsRecur(total, coins, 0));
        //cc.numberOfSolutionsRecur(total, coins);
        System.out.println("DP" + cc.totalNum);
        /*System.out.println(cc.numberOfSolutionsOnSpace(total, coins));
        cc.printCoinChangingSolution(total, coins);*/
    }

    private int numberOfSolutionsRecur(int total, int[] coins, int index) {
        if (total == 0) {
            return 1;
        } else if (total < 0) {
            return 0;
        } else if (index >= coins.length) {
            return 0;
        }
        if (totalToValues[total][index] != -1) {
            return totalToValues[total][index];
        }
        int sum = numberOfSolutionsRecur(total - coins[index], coins, index) +
                numberOfSolutionsRecur(total, coins, index + 1);
        totalToValues[total][index] = sum;
        return sum;
    }

    private boolean numberOfSolutions(int total, int[] coins, int currIndex) {
        if (total == 0) {
            totalNum++;
            return true;
        } else if (total < 0) {
            return false;
        } else {
            for (int i = currIndex; i < coins.length; i++) {
                if (total - coins[i] < 0) {
                    continue;
                }
                if (totalToValues[total - coins[i]][i] == -1) {
                    Boolean solution = numberOfSolutions(total - coins[i], coins, i);
                    if (solution) {
                        totalToValues[total - coins[i]][i] = 1;
                    } else {
                        totalToValues[total - coins[i]][i] = 0;
                    }

                } else if (totalToValues[total - coins[i]][i] == 1) {
                    totalNum++;
                } else if (totalToValues[total - coins[i]][i] == 0) {

                }

            }
        }
        return false;
    }
}
