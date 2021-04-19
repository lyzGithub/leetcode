package medium.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131
{
    public static void main(String[] args)
    {
    }

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s)
    {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            List<String> list = new ArrayList<>();
            palindrome(sChar, i, list);
            if (list.size() > 0) {
                result.add(list);
            }
        }
        return result;
    }

    private void palindrome(char[] chars, int start, List<String> list)
    {
        if (start >= chars.length) {
            int count = 0;
            for (String s : list) {
                count += s.length();
            }
            if (count == chars.length) {
                result.add(list);
            }
            return;
        }
        for (int i = 0; i < chars.length - start; i++) {
            if (isPalindrome(chars, start, start + i)) {
                String str = new String(chars, start, i + 1);
                List<String> tem = new ArrayList<>(list);
                tem.add(str);
                palindrome(chars, start + i + 1, tem);
            }
        }
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
