package medium.string;

public class LongestPalindromicSubsequence516
{
    public int longestPalindromeSubseq(String s)
    {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][chars.length - 1];
    }
}
