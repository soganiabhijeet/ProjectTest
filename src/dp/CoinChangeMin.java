package dp;

import java.util.HashMap;
import java.util.Objects;

public class CoinChangeMin {
    int minChange = Integer.MAX_VALUE;
    static HashMap<Soln, Integer> solnIntegerHashMap = new HashMap<>();

    public static void main(String args[]) {
        int coins[] = {470,18,66,301,403,112,360};
        int m = coins.length;
        int V = 8235;
        CoinChangeMin coinChangeMin = new CoinChangeMin();
        coinChangeMin.setMinChange(coins, V, 0, 0);

        System.out.println("Minimum coins required is " + coinChangeMin.minChange);
    }

    int setMinChange(int[] coins, int amount, int currIndex, int currentNum) {
        //System.out.println("amount " + amount + " currIndex " + currIndex + " currNum" + currentNum);
        if (amount == 0) {
            if (currentNum < minChange) {
                minChange = currentNum;
            }
            return currentNum;
        }
        if (amount < 0) {
            return 0;
        }
        if (currIndex >= coins.length) {
            return 0;
        }
        Soln inputSoln = new Soln(currentNum, currIndex, amount);
        if (solnIntegerHashMap.containsKey(inputSoln)) {
            return solnIntegerHashMap.get(inputSoln);
        }
        int soln = setMinChange(coins, amount - coins[currIndex], currIndex, currentNum + 1) +
                setMinChange(coins, amount, currIndex + 1, currentNum);
        solnIntegerHashMap.put(inputSoln, soln);
        return soln;
    }


    public class Soln {
        Integer currNum;
        Integer currIndex;
        Integer amount;

        public Soln(Integer currNum, Integer currIndex, Integer amount) {
            this.currNum = currNum;
            this.currIndex = currIndex;
            this.amount = amount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Soln soln = (Soln) o;
            return currNum.equals(soln.currNum) &&
                    currIndex.equals(soln.currIndex) &&
                    amount.equals(soln.amount);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currNum, currIndex, amount);
        }
    }


}
