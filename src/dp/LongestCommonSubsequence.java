package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LongestCommonSubsequence {
    static Integer totalCountAtEnd = 0;
    static Integer totalCount = 0;

    class Index {
        int text1Index;
        int text2Index;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return text1Index == index.text1Index &&
                    text2Index == index.text2Index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(text1Index, text2Index);
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceRecur(text1, text2, 0, 0, new HashMap<>());
    }

    private int longestCommonSubsequenceRecur(String text1, String text2, int index1, int index2, Map<Index, Integer> indexIntegerMap) {
        totalCount++;
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }
        Index index = new Index();
        index.text1Index = text1.length() - index1 - 1;
        index.text2Index = text2.length() - index2 - 1;
        if (indexIntegerMap.containsKey(index)) {
            return indexIntegerMap.get(index);
        }
        totalCountAtEnd++;
        int result;
        if (text1.charAt(index1) == text2.charAt(index2)) {
            result = longestCommonSubsequenceRecur(text1, text2, index1 + 1, index2 + 1, indexIntegerMap) + 1;
        } else {
            result = Integer.max(longestCommonSubsequenceRecur(text1, text2, index1 + 1, index2, indexIntegerMap),
                    longestCommonSubsequenceRecur(text1, text2, index1, index2 + 1, indexIntegerMap));
        }
        indexIntegerMap.put(index, result);
        return result;
    }

    public static void main(String args[]) {
        LongestCommonSubsequence k = new LongestCommonSubsequence();
        String str1 = "hofubmnylkra";
        String str2 = "pqhgxgdofcvmr";
        int r1 = k.longestCommonSubsequence(str1, str2);
        System.out.println(r1);
        System.out.println(totalCount);
        System.out.println(totalCountAtEnd);
    }
}
