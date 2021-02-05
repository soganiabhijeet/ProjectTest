package stackqueue;

import java.util.ArrayList;
import java.util.TreeSet;

public class RemoveDuplicateMaintainingOrder {
    public String removeDuplicateLetters(String s) {
        TreeSet<Character> treeSet = new TreeSet<>();
        for (Character c : s.toCharArray()) {
            treeSet.add(c);
        }
        StringBuilder sBuilder = new StringBuilder(new String());
        for (Character c : treeSet) {
            sBuilder.append(c);
        }
        s = sBuilder.toString();

        return s;
    }

    public static void main(String[] args) {
        RemoveDuplicateMaintainingOrder removeDuplicateMaintainingOrder = new RemoveDuplicateMaintainingOrder();
        removeDuplicateMaintainingOrder.removeDuplicateLetters("bcabc");
    }
}
