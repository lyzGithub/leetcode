package medium.link;

import util.ListNode;

public class SwapNodesInPairs
{
    public static void main(String[] args)
    {
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = second.next;
        second.next = first;
        head = second;
        first = head;
        second = first.next;
        ListNode pre = second;
        while(second.next != null && second.next.next!=null) {
            first = second.next;
            second = second.next.next;
            first.next = second.next;
            second.next = first;
            pre.next = second;
            second = first;
            pre = second;
        }
        return head;
    }
}
