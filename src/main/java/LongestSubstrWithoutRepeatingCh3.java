import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWithoutRepeatingCh3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        Set<Character> chSet = new HashSet<>();
        char[] arr = s.toCharArray();
        int pre =0;
        chSet.add(arr[pre]);
        int max = 1;
        int now = 1;
        for (;now <arr.length; now ++ ) {
            while (chSet.contains(arr[now])) {
                chSet.remove(arr[pre]);
                pre ++;
            }
            chSet.add(arr[now]);
            if (chSet.size() > max) {
                max = chSet.size();
            }
        }
        return max;
    }
}
