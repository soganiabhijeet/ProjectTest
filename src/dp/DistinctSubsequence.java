package dp;

import java.util.HashMap;
import java.util.Objects;

public class DistinctSubsequence {
    static Integer totalCountAtEnd = 0;
    static Integer totalCount = 0;

    private class Index {
        Integer startIndex;
        Integer endIndex;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return Objects.equals(startIndex, index.startIndex) &&
                    Objects.equals(endIndex, index.endIndex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startIndex, endIndex);
        }
    }

    public static void main(String[] args) {
        DistinctSubsequence ds = new DistinctSubsequence();
        ds.numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe"
                , "bddabdcae");

    }

    public void numDistinct(String s, String t) {
        Integer result = recurNumDistinct(t, s, 0, 0);
        System.out.println(result);
        System.out.println(totalCount);
        System.out.println(totalCountAtEnd);
        totalCount = 0;
        totalCountAtEnd = 0;
        Integer result2 = DPNumDistinct(t, s, 0, 0, new HashMap<>());
        System.out.println(result2);
        System.out.println(totalCount);
        System.out.println(totalCountAtEnd);
    }

    public int recurNumDistinct(String small, String large, int smallCurrIndex, int largeCurrIndex) {
        totalCount++;
        if (smallCurrIndex >= small.length()) {
            //Complete match
            return 1;
        } else if (largeCurrIndex >= large.length()) {
            return 0;
        }
        Index index = new Index();
        index.startIndex = smallCurrIndex;
        index.endIndex = largeCurrIndex;
        totalCountAtEnd++;
        Integer sol1 = 0;
        Integer sol2;
        if (small.charAt(smallCurrIndex) == large.charAt(largeCurrIndex)) {
            sol1 = recurNumDistinct(small, large, smallCurrIndex + 1, largeCurrIndex + 1);
        }

        sol2 = recurNumDistinct(small, large, smallCurrIndex, largeCurrIndex + 1);
        return sol1 + sol2;
    }

    public int DPNumDistinct(String small, String large, int smallCurrIndex, int largeCurrIndex, HashMap<Index, Integer> indexIntegerHashMap) {
        totalCount++;
        if (smallCurrIndex >= small.length()) {
            //Complete match
            return 1;
        } else if (largeCurrIndex >= large.length()) {
            return 0;
        }
        Index index = new Index();
        index.startIndex = smallCurrIndex;
        index.endIndex = largeCurrIndex;
        if (indexIntegerHashMap.containsKey(index)) {
            //System.out.println("Key found");
           return indexIntegerHashMap.get(index);
        }
        totalCountAtEnd++;
        Integer sol1 = 0;
        Integer sol2;
        if (small.charAt(smallCurrIndex) == large.charAt(largeCurrIndex)) {
            sol1 = DPNumDistinct(small, large, smallCurrIndex + 1, largeCurrIndex + 1, indexIntegerHashMap);
        }

        sol2 = DPNumDistinct(small, large, smallCurrIndex, largeCurrIndex + 1, indexIntegerHashMap);
        indexIntegerHashMap.put(index, sol1 + sol2);
        return sol1 + sol2;
    }
}
