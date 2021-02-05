package dp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaloonBurst {
    static Integer maxSum = Integer.MIN_VALUE;

    int baloonBurstRecur(List<Integer> input, int sum) {
        if (input == null || input.size() == 0) {
            //We are at end of iteration
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        for (int i = 0; i < input.size(); i++) {
            int leftIndex;
            int rightIndex;
            try {
                leftIndex = input.get(i - 1);
            } catch (IndexOutOfBoundsException exception) {
                leftIndex = 1;
            }
            try {
                rightIndex = input.get(i + 1);
            } catch (IndexOutOfBoundsException exception) {
                rightIndex = 1;
            }
            int value = input.get(i);

            System.out.println("i: " + input.get(i) + " leftIndex: " + leftIndex + " rightIndex: " + rightIndex +
                    "sum: " + sum);
            ArrayList<Integer> cloneArray = new ArrayList<>();
            Iterator<Integer> iterator = input.iterator();
            while (iterator.hasNext()) {
                //Add the object clones
                cloneArray.add(iterator.next());
            }
            cloneArray.remove(i);

            baloonBurstRecur(cloneArray, sum + value * leftIndex * rightIndex);
        }
        return sum;
    }

    private static String listPrint(List<Integer> input) {
        StringBuffer stringBuffer = new StringBuffer();
        input.forEach(integer -> stringBuffer.append(integer + ","));
        return stringBuffer.toString();
    }

    public static void main(String args[]) {

        int input[] = {3, 1, 5, 8};
        ArrayList<Integer> listOfInts = IntStream.of(input).boxed().collect(Collectors.toCollection(ArrayList::new));
        BaloonBurst baloonBurst = new BaloonBurst();
        //baloonBurst.baloonBurstRecur(listOfInts, 0);
        baloonBurst.baloonBurstDP(listOfInts, 0, new HashMap<>());
        System.out.println(maxSum);
    }

    int baloonBurstDP(List<Integer> input, int sum, HashMap<String, Integer> hashMap) {
        if (input == null || input.size() == 0) {
            //We are at end of iteration
            if (sum > maxSum) {
                maxSum = sum;
            }
        }


        for (int i = 0; i < input.size(); i++) {

            int leftIndex;
            int rightIndex;
            try {
                leftIndex = input.get(i - 1);
            } catch (IndexOutOfBoundsException exception) {
                leftIndex = 1;
            }
            try {
                rightIndex = input.get(i + 1);
            } catch (IndexOutOfBoundsException exception) {
                rightIndex = 1;
            }
            if(input.size()==4 && input.get(i)==1){
                System.out.println("Interesting input length is " + input.size() + "i: " + input.get(i) + " leftIndex: " + leftIndex + " rightIndex: " + rightIndex +
                        "sum: " + sum);

            }
            if(input.size()==3 && input.get(i)==5){
                System.out.println("Interesting input length is " + input.size() + "i: " + input.get(i) + " leftIndex: " + leftIndex + " rightIndex: " + rightIndex +
                        "sum: " + sum);

            }
            if(input.size()==2 && input.get(i)==3){
                System.out.println("Interesting input length is " + input.size() + "i: " + input.get(i) + " leftIndex: " + leftIndex + " rightIndex: " + rightIndex +
                        "sum: " + sum);

            }
            if(input.size()==1 && input.get(i)==8){
                System.out.println("Interesting input length is " + input.size() + "i: " + input.get(i) + " leftIndex: " + leftIndex + " rightIndex: " + rightIndex +
                        "sum: " + sum);

            }
            int value = input.get(i);

            System.out.println("input length is " + input.size() + "i: " + input.get(i) + " leftIndex: " + leftIndex + " rightIndex: " + rightIndex +
                    "sum: " + sum);
            //Add the object clones
            ArrayList<Integer> cloneArray = new ArrayList<>(input);
            cloneArray.remove(i);
            if (hashMap.containsKey(listPrint(cloneArray))) {
                System.out.println("Sum calculated is  " + (sum + value * leftIndex * rightIndex));

                return hashMap.get(listPrint(cloneArray));
            }
            System.out.println("Sum calculated is  " + (sum + value * leftIndex * rightIndex));
            hashMap.put(listPrint(cloneArray), sum + value * leftIndex * rightIndex);
            baloonBurstDP(cloneArray, sum + value * leftIndex * rightIndex, hashMap);
        }
        return 0;
    }
}
