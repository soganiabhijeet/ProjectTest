package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/remove-invalid-parentheses/
public class RemoveInvaliParanthesis {

    //https://www.youtube.com/watch?v=Cbbf5qe5stw&ab_channel=Pepcoding

    HashSet<String> set = new HashSet();

    public List<String> removeInvalidParentheses(String s) {
        int minRemoval = getMinRemoval(s);
        System.out.println("minRemoval " + minRemoval);
        removeInvalidParenthesesUtil(s, minRemoval, set);
        return new ArrayList<String>(set);
    }

    private void removeInvalidParenthesesUtil(String s, int minRemoval, HashSet<String> hashSet) {
        if (minRemoval == 0) {
            int min = getMinRemoval(s);
            if (min == 0) {
                hashSet.add(s);

            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == ')') {
                String left = s.substring(0, i);
                String right = "";
                try {
                    right = s.substring(i + 1);
                } catch (Exception e) {

                }
                removeInvalidParenthesesUtil(left + right, minRemoval - 1, hashSet);
            }
        }
    }


    private int getMinRemoval(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (stack.isEmpty()) {
                    stack.push(c);
                }
                else if(stack.peek()=='(' && c==')'){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }

        }
        return stack.size();
    }

    public static void main(String[] args) {
        RemoveInvaliParanthesis removeInvaliParanthesis = new RemoveInvaliParanthesis();
        removeInvaliParanthesis.removeInvalidParentheses("()())()");

    }
}
