package hard;

public class CreateSortedArrayThroughInstructions1649
{
    public static void main(String[] args)
    {
        int[] instructions = {1, 5, 6, 2};
        System.out.println(createSortedArray(instructions));
    }

    private static int mod = 1000000007;

    public static int createSortedArray(int[] instructions)
    {
        int ub = findMax(instructions);
        Bit bit = new Bit(ub);
        long ans = 0;
        for (int i = 0; i < instructions.length; ++i) {
            int x = instructions[i];
            int smaller = bit.query(x - 1);
            int larger = i - bit.query(x);
            ans += Math.min(smaller, larger);
            if (ans > mod) {
                ans = ans % mod;
            }
            bit.update(x);
        }
        return (int) ans % mod;
    }

    public static int findMax(int[] array)
    {
        if (array.length == 1) {
            return array[0];
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}

class Bit
{
    private int number;
    int[] tree;

    public Bit(int n)
    {
        this.number = n;
        tree = new int[number + 1];
    }

    public static int lowbit(int x)
    {
        return x & (-x);
    }

    public void update(int x)
    {
        while (x <= number) {
            tree[x] = ++tree[x];
            x += lowbit(x);
        }
    }

    public int query(int x)
    {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }
}
