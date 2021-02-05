package dp;

import java.util.List;

public class WordWrap {
    private int max = 10;

    public static void main(String[] args) {

    }

    int wordWrapRecur(List<String> stringList, int currentIndex, int currentRemaining, int currentCost) {
        if (currentIndex == stringList.size()) {
            return currentCost;
        }
        //Either move the string to next line
        //Or keep the string in current line
        int costIfMovedToNextLine = stringList.get(currentIndex).length();
        if (stringList.get(currentIndex).length() > currentRemaining) {
            return 1;
        }
        return 1;
    }
}
