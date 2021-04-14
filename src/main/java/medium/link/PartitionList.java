package medium.link;

import util.ListNode;

public class PartitionList
{
    public static void main(String[] args)
    {
    }

    public ListNode partition(ListNode head, int x)
    {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode bigList = new ListNode();
        ListNode bigTail = bigList;
        ListNode smallList = new ListNode();
        ListNode smallTail = smallList;
        ListNode preHead = head;
        while (preHead != null) {
            if (preHead.val < x) {
                smallTail.next = preHead;
                smallTail = preHead;
                preHead = preHead.next;
                smallTail.next = null;
            }
            else {
                bigTail.next = preHead;
                bigTail = preHead;
                preHead = preHead.next;
                bigTail.next = null;
            }
        }
        smallTail.next = bigList.next;
        bigList.next = null;
        ListNode nowHead = smallList.next;
        smallList.next = null;
        return nowHead;
    }
}
