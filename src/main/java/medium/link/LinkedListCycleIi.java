package medium.link;

import util.ListNode;

public class LinkedListCycleIi
{
    public static void main(String[] args)
    {
    }

    public ListNode detectCycle(ListNode head)
    {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode listSlow = head;
        ListNode listFast = head;
        while (listFast != null && listFast.next != null) {
            listSlow = listSlow.next;
            listFast = listFast.next.next;
            if (listSlow == listFast) {
                ListNode slow2 = head;
                while (slow2 != listSlow) {
                    listSlow = listSlow.next;
                    slow2 = slow2.next;
                }
                return listSlow;
            }
        }
        return null;
    }
}
