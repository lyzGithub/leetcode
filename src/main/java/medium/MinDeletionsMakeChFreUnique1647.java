package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinDeletionsMakeChFreUnique1647
{
    public static void main(String[] args)
    {
        String s = "aaabbbcc";
        System.out.println(minDeletions(s));
    }

    public static int minDeletions(String s)
    {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chs) {
            int count = 1;
            if (map.containsKey(ch)) {
                count += map.get(ch);
            }
            map.put(ch, count);
        }
        List<Integer> all = new ArrayList<>(map.values());
        Collections.sort(all);
        int count = 0;
        for (int i = all.size() - 1; i >= 0; i--) {
            int unique = all.get(i);
            all.set(i, -1);
            while (unique != 0 && all.contains(unique)) {
                unique--;
                count++;
            }
            all.set(i, unique);
        }
        return count;
    }
}
