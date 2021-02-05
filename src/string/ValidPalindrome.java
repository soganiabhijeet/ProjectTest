package string;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
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
