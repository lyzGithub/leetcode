package hard.string;

public class ShortestPalindrome214
{
    public static void main(String[] args)
    {
    }

    public String shortestPalindrome(String s)
    {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int maxIndex = 0;
        for (int i=chars.length-1; i>=0; i--) {
            if (isPalindrome(chars, 0, i)) {
                maxIndex = i;
                break;
            }
        }
        StringBuilder re = new StringBuilder(s);
        for (int i = maxIndex+1; i<chars.length; i++) {
            re.insert(0, chars[i]);
        }
        return re.toString();
    }

    private static boolean isPalindrome(char[] chars, int start, int end)
    {
        if (start < 0 || end >= chars.length || start > end) {
            return false;
        }

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
