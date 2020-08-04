import java.util.HashSet;
import java.util.Set;

public class String2IntegerAtoi8 {
    static Set<Character> chSet = new HashSet<>();
    static {
        chSet.add('0');
        chSet.add('1');
        chSet.add('2');
        chSet.add('3');
        chSet.add('4');
        chSet.add('5');
        chSet.add('6');
        chSet.add('7');
        chSet.add('8');
        chSet.add('9');
    }
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chs = str.toCharArray();
        int tag = 1;
        StringBuilder sb = new StringBuilder();
        Outer:
        for (int i=0; i<chs.length; i++) {
            if (chs[i] == ' ') {
            } else {
                boolean leadingZero = true;
                boolean leading = true;
                boolean numsed = false;
                while (i < chs.length) {
                    if (leading && chs[i] == '-') {
                        tag = -1;
                        leading = false;
                        if (numsed) {
                            tag = 1;
                            break Outer;
                        }
                    } else if (leading && chs[i] == '+') {
                        leading = false;
                        tag = 1;
                        if (numsed) {
                            break Outer;
                        }
                    } else if (leadingZero && chs[i] == '0') {
                        numsed = true;
                    } else if (chSet.contains(chs[i])) {
                        leadingZero = false;
                        sb.append(chs[i]);
                        numsed = true;

                    } else {
                        break Outer;
                    }
                    i++;
                }
            }
        }
        String strTmp = sb.toString();
        if (strTmp.length() == 0) {
            return 0;
        }
        if (strTmp.length() > 10) {
            if (tag ==-1) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        long tmp = Long.parseLong(strTmp);
        if (tag == -1) {
            if (tmp > (long) Integer.MAX_VALUE+1) {
                return Integer.MIN_VALUE;
            }
        }
        if (tag == 1) {
            if (tmp > (long) Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) tmp * tag;
    }
    public static void main(String[] args) {
        String s = "-2147483649";
        System.out.println(myAtoi(s));
    }
}
