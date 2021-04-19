package easy.string;

public class ReverseString
{
    public static void main(String[] args)
    {
    }

    public void reverseString(char[] s)
    {
        if (s == null || s.length == 1) {
            return;
        }
        int len = s.length;
        int first = 0;
        int last = len - 1;
        while (first < last) {
            char temp = s[first];
            s[first] = s[last];
            s[last] = temp;
            first++;
            last--;
        }
    }
}
