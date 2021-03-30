package medium;

import java.util.HashMap;
import java.util.Map;

public class MakFileNameUnique1487
{
    public String[] getFolderNames(String[] names)
    {
        if (names == null) {
            return null;
        }
        String[] results = new String[names.length];
        Map<String, Integer> unique = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!unique.containsKey(name)) {
                results[i] = name;
                unique.put(name, 1);
            }
            else {
                int count = unique.get(name);
                while (unique.containsKey(name + "(" + count + ")")) {
                    count++;
                }
                String res = name + "(" + count + ")";
                unique.put(res, 1);
                unique.put(name, count);
                results[i] = res;
            }
        }
        return results;
    }
}
