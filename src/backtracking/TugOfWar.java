package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TugOfWar {
//https://www.tutorialcup.com/interview/array/tug-war.htm
    private ArrayList leftBestSol = new ArrayList();
    private ArrayList rightBestSol = new ArrayList();
    private Integer leastDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int arr[] = {23, 45, -34, 12, 0, 98,
                -99, 4, 189, -1, 4};
        TugOfWar a = new TugOfWar();
        a.tugOfWar((ArrayList) Collections.singletonList(arr));
    }

    private void tugOfWar(ArrayList input) {


    }

    private int difference(ArrayList<Integer> left, ArrayList<Integer> right) {
        int sumLeft = 0;
        int sumRight = 0;
        for (Integer integer : left) {
            sumLeft += integer;
        }

        for (Integer integer : right) {
            sumRight += integer;
        }
        return Math.abs(sumLeft - sumRight);
    }
}
