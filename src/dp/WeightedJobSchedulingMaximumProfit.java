package dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class WeightedJobSchedulingMaximumProfit {

    int MAX_TILL_NOW = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //[1,2,3,3]
        //[3,4,5,6]
        //[50,10,40,70]
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        WeightedJobSchedulingMaximumProfit weightedJobSchedulingMaximumProfit = new WeightedJobSchedulingMaximumProfit();
        System.out.println(weightedJobSchedulingMaximumProfit.jobScheduling(startTime, endTime, profit));
    }

    private class Job {
        int startTime;
        int endTime;
        int profit;
    }

    private class SortInAscendingOrder implements Comparator<Job> {


        @Override
        public int compare(Job o1, Job o2) {
            return o1.endTime - o2.endTime;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        HashMap<Integer, Integer> dpList = new HashMap<>();
        for (int i = 0; i < startTime.length; i++) {
            Job job = new Job();
            job.endTime = endTime[i];
            job.startTime = startTime[i];
            job.profit = profit[i];
            dpList.put(i, -1);
            jobs.add(job);
        }
        jobs.sort(new SortInAscendingOrder());
        return recursiveGetMax(jobs, jobs.size() - 1, dpList);
        //return MAX_TILL_NOW;
    }

    private int recursiveGetMax(List<Job> jobs, int index, HashMap<Integer, Integer> dplist) {
        if (index < 0) {
            return 0;
        }
        if (dplist.get(index) != -1) {
            return dplist.get(index);
        }
        //Current value is in output
        int latestValueThatCanBePicked = -1;
        int indexCpy = index;
        while (indexCpy != -1) {
            if (jobs.get(index).startTime >= jobs.get(indexCpy).endTime) {
                latestValueThatCanBePicked = indexCpy;
                break;
            }
            indexCpy--;
        }

        Integer output = Integer.max(recursiveGetMax(jobs, index - 1, dplist), recursiveGetMax(jobs, latestValueThatCanBePicked, dplist) + jobs.get(index).profit);
        dplist.put(index, output);
        return output;

    }
}
