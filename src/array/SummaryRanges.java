package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    //TODO do this.
    public static void main(String args[]) {
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        List<Range> range = new ArrayList<>();
        Range currRange = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (currRange == null) {
                currRange = new Range();
                currRange.start = nums[i];

            }
            if (nums[i] + 1 == nums[i + 1]) {

            } else {
                //End this range
                range.add(currRange);
                currRange = new Range();
            }
        }
    }


    static class Range {
        int start;
        int end;

    }
}

