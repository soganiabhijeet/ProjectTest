package dp;

import java.util.HashMap;
import java.util.Map;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/DecodeWays.java
//Good https://leetcode.com/problems/decode-ways/
public class DecodeWays {


    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Integer, Integer> count = new HashMap<>();
        return numDecodingsUtil(s, 0, count);
    }

    private int numDecodingsUtil(String s, int currindex, Map<Integer, Integer> map) {
        if (s.length() == currindex) {
            return 1;
        }
        if (map.containsKey(currindex)) {
            return map.get(currindex);
        }
        String s1 = s.substring(currindex, currindex + 1);
        if (s1.equals("0")) {
            //We can never have a combination starting with 0. "10" would be covered in another call
            return 0;
        }
        int c1 = numDecodingsUtil(s, currindex + 1, map);
        int c2 = 0;
        if (currindex < s.length() - 1) {
            String s2 = s.substring(currindex, currindex + 2);
            if (Integer.valueOf(s2) <= 26) {
                c2 = numDecodingsUtil(s, currindex + 2, map);
            }
        }
        int result = c1 + c2;
        map.put(currindex, result);
        return result;
    }
}
