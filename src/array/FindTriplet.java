package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class FindTriplet {

    public static void main(String args[]) {
        FindTriplet tip = new FindTriplet();
        int input[] = {-1, 0, 1, 2, -1, -4};
        int sum = 22;
        System.out.println(tip.isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(tip.findTriplet(input));
    }

    public List<List<Integer>> findTriplet(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    if (!listList.contains(list)) {
                        listList.add(list);
                    }
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return listList;
    }

    public boolean isPalindrome(String s) {
        int j = s.length() - 1;
        int i = 0;

        while (i < j) {
            System.out.println(s.charAt(i));
            System.out.println(s.charAt(j));
            if (isAlphaNumeric(s.charAt(i)) && isAlphaNumeric(s.charAt(j))) {
                if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else if (!isAlphaNumeric(s.charAt(i))) {
                i++;
            } else if (!isAlphaNumeric(s.charAt(j))) {
                j--;
            }
        }
        return true;
    }



    private boolean isAlphaNumeric(char ch) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }
}
