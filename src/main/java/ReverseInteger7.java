
public class ReverseInteger7 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int tag;
        if (x < 0) {
            tag = -1;
        } else {
            tag = 1;
        }
        long tmp = Math.abs((long)x);
        StringBuilder sb = new StringBuilder(String.valueOf(tmp));
        String result = sb.reverse().toString();
        while(result.charAt(0) == '0') {
            result = result.substring(1, result.length());
        }
        if (tag == 1) {
            if (Long.parseLong(result) > (long) Integer.MAX_VALUE) {
                return 0;
            }
        }
        if (tag == -1) {
            if (Long.parseLong(result) > (long) Integer.MAX_VALUE + 1) {
                return 0;
            }
        }

        return Integer.parseInt(result) * tag;
    }
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("1534236469"));
        System.out.println(Integer.parseInt(new StringBuilder("1534236469").reverse().toString()));

    }
}
