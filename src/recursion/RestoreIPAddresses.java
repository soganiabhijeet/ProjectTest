package recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    List<String> result = new ArrayList();

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddressesUtil(1, s, 0);
        System.out.println(result);
        return result;
    }

    public void restoreIpAddressesUtil(int currNum, String actualString, Integer currStringIndex) {

        if (currNum == 4) {
            String currString = actualString.substring(currStringIndex);
            if (isValid(currString)) {
                result.add(actualString);
            }
            return;
        }
        for (int i = 1; i < 5; i++) {
            if (currStringIndex + i <= actualString.length()) {
                String string = actualString.substring(currStringIndex, currStringIndex + i);


                if (isValid(string)) {

                    String newActualString = insertString(actualString, ".", currStringIndex + i - 1);
                    restoreIpAddressesUtil(currNum + 1, newActualString, currStringIndex + i + 1);
                }
            }
        }

    }

    // Function to insert string
    private String insertString(
            String originalString,
            String stringToBeInserted,
            int index) {

        // Create a new string
        String newString = originalString.substring(0, index + 1)
                + stringToBeInserted
                + originalString.substring(index + 1);

        // return the modified String
        return newString;
    }

    private boolean isValid(String currString) {
        if (currString.equals("0")) {
            return true;
        }
        if (currString.startsWith("0")) {
            return false;
        }
        Integer num;
        try {
            num = Integer.valueOf(currString);
        } catch (Exception e) {
            return false;
        }
        if (num > 0 && num < 256) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        restoreIPAddresses.restoreIpAddresses("0000");
    }
}
