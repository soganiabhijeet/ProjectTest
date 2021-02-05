package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WildCardMatching {
    class Index {
        String text1Index;
        String text2Index;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WildCardMatching.Index index = (WildCardMatching.Index) o;
            return text1Index.equals(index.text1Index) &&
                    text2Index.equals(index.text2Index);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text1Index, text2Index);
        }
    }

    public static void main(String[] args) {
        WildCardMatching wildCardMatching = new WildCardMatching();
        System.out.println(wildCardMatching.isMatch("b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a", "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb"));
    }

    public boolean isMatch(String pattern, String string) {
        return isMatchUtil(pattern, string, new HashMap<>());
    }

    private boolean isMatchUtil(String pattern, String string, Map<WildCardMatching.Index, Boolean> indexIntegerMap) {

        // If we reach at the end of both strings,
        // we are done
        WildCardMatching.Index index = new WildCardMatching.Index();
        index.text1Index = pattern;
        index.text2Index = string;
        if (indexIntegerMap.containsKey(index)) {
            return indexIntegerMap.get(index);
        }
        if (pattern.length() == 0 && string.length() == 0) {
            indexIntegerMap.put(index, true);
            return true;
        }


        //For case **
        if (pattern.length() > 1 && pattern.charAt(0) == '*' && pattern.charAt(1) == '*') {
            return isMatchUtil(pattern.substring(1), string, indexIntegerMap);
        }
        // Make sure that the characters after '*'
        // are present in second string.
        if (pattern.length() > 1 && pattern.charAt(0) == '*' &&
                string.length() == 0) {
            indexIntegerMap.put(index, false);
            return false;
        }


        // If the pattern string contains '?',
        // or current characters of both strings match
        if ((pattern.length() > 0 && pattern.charAt(0) == '?' && string.length() != 0) ||
                (pattern.length() != 0 && string.length() != 0 &&
                        pattern.charAt(0) == string.charAt(0))) {
            return isMatchUtil(pattern.substring(1),
                    string.substring(1), indexIntegerMap);

        }

        // If there is *, then there are two possibilities
        // a) We consider current character of second string
        // b) We ignore current character of second string.
        if (pattern.length() > 0 && pattern.charAt(0) == '*') {
            return isMatchUtil(pattern.substring(1),
                    string, indexIntegerMap) || isMatchUtil(pattern, string.substring(1), indexIntegerMap);
        }
        indexIntegerMap.put(index, false);
        return false;
    }
}
