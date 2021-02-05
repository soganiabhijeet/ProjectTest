package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CanPartitionKSubsets {

    public static void main(String[] args) {
        CanPartitionKSubsets canPartitionKSubsets = new CanPartitionKSubsets();
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(canPartitionKSubsets.canPartitionKSubsets(nums, k, 0, new HashMap()));
    }

    public boolean canPartitionKSubsets(int[] nums, int k, int index, HashMap<Integer, ArrayList<Integer>> listHashMap) {

        if (index == nums.length) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        if (index == nums.length - 1) {
            ArrayList<Integer> sumList = new ArrayList<>();
            //Check if all values are same
            for (Integer key : listHashMap.keySet()) {
                sumList.add(sumOfList(listHashMap.get(key)));
            }
            return checkIfEqual(sumList);
        }
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list;
            list = listHashMap.get(i);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(nums[index]);
            listHashMap.put(i, list);
            boolean retVal = canPartitionKSubsets(nums, k, index + 1, listHashMap);
            return retVal;
        }
        return false;
    }

    private boolean checkIfEqual(ArrayList<Integer> list) {
        if (list.size() == 1) {
            return false;
        }
        int first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != first) {
                return false;
            }
        }
        return true;
    }

    private int sumOfList(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        return sum;
    }
}
