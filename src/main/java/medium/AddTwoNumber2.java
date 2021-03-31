package medium;

import util.ListNode;

public class AddTwoNumber2
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode result = null;
        ListNode tmp = null;
        int up = 0;
        ListNode l11 = l1;
        ListNode l22 = l2;
        while (l11 != null || l22 != null) {
            int num1 = 0;
            int num2 = 0;
            if (l11 != null) {
                num1 = l11.val;
                l11 = l11.next;
            }
            if (l22 != null) {
                num2 = l22.val;
                l22 = l22.next;
            }
            if (result == null) {
                int re = (num1 + num2 + up) % 10;
                up = (num1 + num2 + up) / 10;
                result = new ListNode(re);
                tmp = result;
            }
            else {
                int re = (num1 + num2 + up) % 10;
                up = (num1 + num2 + up) / 10;
                ListNode now = new ListNode(re);
                tmp.next = now;
                tmp = now;
            }
        }
        if (up != 0) {
            tmp.next = new ListNode(up);
        }
        return result;
    }
}
