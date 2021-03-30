package medium;

import java.math.BigInteger;
import java.util.Arrays;

public class SellDiminishingValuedColoredDalls1648
{
    public static void main(String[] args)
    {
        int[] inventory = {1000000000};
        int order = 1000000000;
        System.out.println(maxProfit(inventory, order));
    }

    public static final int MOD = 1000000007;

    public static int maxProfit(int[] inventory, int orders)
    {
        Arrays.sort(inventory);
        int inventoryLength = inventory.length;
        long result = 0;
        if (inventory == null || inventory.length == 0) {
            return 0;
        }
        if (inventory.length == 1) {
            if (inventory[0] >= orders) {
                return BigInteger.valueOf(inventory[0]).add(BigInteger.valueOf(inventory[0] - orders + 1))
                        .multiply(BigInteger.valueOf(orders)).divide(BigInteger.valueOf(2)).mod(BigInteger.valueOf(MOD)).intValue();
            }
            else {
                return BigInteger.valueOf(inventory[0]).multiply(BigInteger.valueOf(orders))
                        .divide(BigInteger.valueOf(2)).mod(BigInteger.valueOf(MOD)).intValue();
            }
        }
        for (int i = 0; i < orders; i++) {
            int max = inventory[inventoryLength - 1];
            if (max <= 0) {
                return (int) result % MOD;
            }
            result = (result + max);
            if (result >= MOD) {
                result = result % MOD;
            }
            inventory[inventoryLength - 1] = max - 1;
            int now = inventoryLength - 1;
            while (now > 0 && inventory[now] < inventory[now - 1]) {
                int temp = inventory[now - 1];
                inventory[now - 1] = inventory[now];
                inventory[now] = temp;
                now--;
            }
        }
        return (int) (result % MOD);
    }
}
