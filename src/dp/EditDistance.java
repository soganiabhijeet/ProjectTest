package dp;

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";

        System.out.println(new EditDistance().editDist(str1, str2, str1.length(), str2.length()));
    }

/*    private Integer editDist(String fromWord, String toWord, int fromWordIndex, int toWordIndex, int totalEdits) {
        if (fromWordIndex == fromWord.length() && toWordIndex == toWord.length()) {
            return totalEdits;
        }
        if (fromWordIndex == fromWord.length() || toWordIndex == toWord.length()) {
            return Integer.MAX_VALUE;
        } else if (fromWord.charAt(fromWordIndex) == toWord.charAt(toWordIndex)) {
            return editDist(fromWord, toWord, fromWordIndex + 1, toWordIndex + 1, totalEdits);
        }
        int replace = editDist(fromWord, toWord, fromWordIndex + 1, toWordIndex + 1, totalEdits + 1);
        int insert = editDist(fromWord, toWord, fromWordIndex, toWordIndex + 1, totalEdits + 1);
        int delete = editDist(fromWord, toWord, fromWordIndex + 1, toWordIndex, totalEdits + 1);
        return Math.min(Math.min(replace, insert), delete);
    }*/


     int editDist(String str1, String str2, int m, int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDist(str1, str2, m - 1, n - 1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + Integer.min(editDist(str1, str2, m, n - 1),
                // Insert
                Integer.min(editDist(str1, str2, m - 1, n), // Remove
                editDist(str1, str2, m - 1, n - 1)) // Replace
        );
    }
}
