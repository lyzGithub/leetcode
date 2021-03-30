package medium;

/**
 * Longest Palindromic Substring
 * center spread
 */
public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() ==0 || s.length() == 1) {
            return s;
        }
        int length = s.length();
        char[] chs = s.toCharArray();
        String maxString = "" + chs[0];
        for (int i=0; i<length; i++) {
            String max1 =  centerSpread(s, i, i);
            String max2 = centerSpread(s, i, i+1);
            String max = max1.length() > max2.length() ? max1:max2;
            maxString = max.length() > maxString.length() ? max:maxString;
        }
        return maxString;
    }

    public String centerSpread(String chs, int left, int right) {
        int length = chs.length();
        int i = left;
        int j = right;
        while(i>=0 && j<=length-1) {
            if(chs.charAt(i) == chs.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return chs.substring(i+1,j);
    }
}
