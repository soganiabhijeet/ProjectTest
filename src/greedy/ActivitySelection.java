package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ActivitySelection {

    // driver program to test above function
    public static void main(String[] args)
    {
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {2, 4, 6, 7, 9, 9};
        int n = s.length;

        printMaxActivities(s, f, n);
    }

    private static void printMaxActivities(int start[], int[] end, int n) {
        String[] array = {"a", "b", "c", "d", "e"};

        //Method 1
        ArrayList<Integer> startList = IntStream.of(start)
                .boxed().collect(Collectors.toCollection(ArrayList::new));


    }
}
