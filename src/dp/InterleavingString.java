package dp;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty()) {
            return s3.isEmpty();
        }
        if (s3.isEmpty()) {
            return false;
        }
        //3 cases
        return (!s1.isEmpty() && s1.charAt(0) == s3.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1)))
                || (!s2.isEmpty() && s2.charAt(0) == s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)));


    }

    /**
     * "aabcc"
     * "dbbca"
     * "aadbbcbcac"
     * @param args
     */

    public static void main(String[] args) {
        InterleavingString interleavingString=new InterleavingString();
        System.out.println(interleavingString.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}
