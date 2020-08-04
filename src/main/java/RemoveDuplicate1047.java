import java.util.Stack;

public class RemoveDuplicate1047 {
    public String removeDuplicates(String S) {
        if (S == null || S.length() <=0){
            return null;
        }
        char[] chs = S.toCharArray();
        Stack<Character> st = new Stack<>();
        int i=0;
        st.push(chs[i]);
        i++;
        while (i<chs.length) {
            if (st.empty()) {
                st.push(chs[i]);
                i++;
                continue;
            }
            if (st.peek().equals(chs[i])) {
                st.pop();
            } else {
                st.push(chs[i]);
            }
            i++;
        }
        StringBuilder result = new StringBuilder();
        while (!st.empty()) {
            result.append(st.pop());
        }
        return result.reverse().toString();
    }
}
