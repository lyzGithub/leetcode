package easy.string;

public class ImplementStrstr
{
    public static void main(String[] args)
    {
    }

    public int strStr(String haystack, String needle)
    {
        if (haystack == null && needle != null) {
            return -1;
        }
        if (needle == null) {
            return 0;
        }
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        for (int i = 0; i < hay.length; i++) {
            boolean temp = true;
            for (int j = 0; j < need.length; j++) {
                if (i + j >= hay.length || hay[i + j] != need[j]) {
                    temp = false;
                    break;
                }
            }
            if (temp) {
                return i;
            }
        }
        return -1;
    }
}
