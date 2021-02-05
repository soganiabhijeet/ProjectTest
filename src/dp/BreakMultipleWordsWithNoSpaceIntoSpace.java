package dp;

import java.util.HashSet;
import java.util.Set;

public class BreakMultipleWordsWithNoSpaceIntoSpace {
    static int T[];
    //https://leetcode.com/problems/word-break/submissions/

    public static void main(String args[]) {
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        String str = "I";
        T = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            T[i] = -1;
        }
        BreakMultipleWordsWithNoSpaceIntoSpace bmw = new BreakMultipleWordsWithNoSpaceIntoSpace();
        Boolean result1 = bmw.breakWordDP(str, dictionary, 0);


        System.out.print(result1);
    }

    private Boolean breakWordRecur(String str, Set<String> dictionary, int index) {
        if (index >= str.length()) {
            return true;
        }
        for (int i = index; i < str.length(); i++) {
            if (dictionary.contains(str.substring(index, i + 1))) {
                if (breakWordRecur(str, dictionary, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean breakWordDP(String str, Set<String> dictionary, int index) {
        if (index >= str.length()) {
            return true;
        }
        if (T[index] == 0) {
            return false;
        } else if (T[index] == 1) {
            return true;
        }
        for (int i = index; i < str.length(); i++) {
            if (dictionary.contains(str.substring(index, i + 1))) {
                if (breakWordDP(str, dictionary, i + 1)) {
                    T[i] = 1;
                    return true;
                }
            }
        }
        T[index] = 0;
        return false;
    }
}
