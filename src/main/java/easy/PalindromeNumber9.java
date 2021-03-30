package easy;

public class PalindromeNumber9 {
    public boolean isPalindromeNumber(int x) {
        String s = String.valueOf(x);
        int i=0;
        int j=s.length()-1;
        while (i<j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
