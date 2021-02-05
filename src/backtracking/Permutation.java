package backtracking;

import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args) {
        String str = "AAC";
        int n = str.length();
        Permutation permutation = new Permutation();
        permutation.permute(new ArrayList(), 0, n, str);
    }

    /**
     * Check if character is already present in str
     *
     * @param str
     * @param index
     * @param character
     * @return
     */
    private boolean isSafe(ArrayList str, int index, Character character) {
        if (str.contains(character)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean permute(ArrayList str, int index, int length, String inputString) {
        if (str.size() == length) {
            System.out.println(str);
            return true;
        }
        for (Character character : inputString.toCharArray()) {
            if (isSafe(str, index, character)) {
                str.add(index, character);
                if (permute(str, index + 1, length, inputString)) {
                    return true;
                } else {
                    str.remove(character);
                }
            }

        }
        return false;
    }
}
