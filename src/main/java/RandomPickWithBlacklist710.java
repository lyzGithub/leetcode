import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomPickWithBlacklist710
{
    public static void main(String[] args)
    {

    }

    private int n;
    private int[] blacks;
    private Random random = new Random();

    public RandomPickWithBlacklist710(int N, int[] blacklist)
    {
        n = N;
        Arrays.sort(blacklist);
        blacks = blacklist;
    }

    public int pickStraight()
    {
        int pickNum = -1;
        List<Integer> list = new ArrayList<>();
        for (int num : blacks) {
            list.add(num);
        }
        Set<Integer> set = new HashSet<>(list);
        while (true) {
            pickNum = random.nextInt(n);
            if (!set.contains(pickNum)) {
                break;
            }
        }
        return pickNum;
    }

    public int pick()
    {
        int k = random.nextInt(n - blacks.length);
        int left = 0;
        int right = blacks.length - 1;

        while (left < right) {
            int i = (left + right + 1) / 2;
            if (blacks[i] - i > k) right = i - 1;
            else left = i;
        }
        return left == right && blacks[left] - left <= k ? k + left + 1 : k;
    }
}
