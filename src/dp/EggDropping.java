package dp;

//http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
public class EggDropping {

    public static void main(String[] args) {
        EggDropping ed = new EggDropping();
        int r = ed.calculate(2, 2);
        System.out.println(r);
    }

    /**
     * We throw egg from all floors x. 2 possibilities for each floor.
     * 1. egg breaks. all floors below are possible. calculate(eggs-1,x-1)
     * 2. egg does not break. all floors above are possible calculate(eggs,floor-x)
     * 3. trails=1+min(calculate(eggs-1,x-1),calculate(eggs,floor-x)).
     */


    private int calculate(int eggs, int floor) {
        if (eggs == 1) {
            return floor;
        }
        if (floor == 1 || floor == 0) {
            return floor;
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= floor; i++) {
            int value = 1 + Integer.max(calculate(eggs - 1, i - 1), calculate(eggs, floor - i));
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }
}
