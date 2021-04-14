package medium.link;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortList
{
    public static void main(String[] args)
    {
    }

    public ListNode sortList1(ListNode head)
    {
        if (head == null || head.next == null) {
            return head;
        }
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode preHead = head;
        while (preHead != null) {
            queue.add(preHead);
            ListNode temp = preHead;
            preHead = preHead.next;
            temp.next = null;
        }
        ListNode nowHead = queue.poll();
        ListNode tail = nowHead;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
        }
        return nowHead;
    }

    public ListNode sortList2(ListNode head)
    {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nowHead = new ListNode();
        nowHead.next = head;
        ListNode nowPre = nowHead;
        while (nowPre.next != null) {
            ListNode tempPre = nowPre;
            ListNode tempNow = nowPre.next;
            ListNode maxPre = tempPre;
            ListNode maxNow = tempNow;
            while (tempNow.next != null) {
                tempPre = tempPre.next;
                tempNow = tempNow.next;
                if (tempNow.val < maxNow.val) {
                    maxPre = tempPre;
                    maxNow = tempNow;
                }
            }
            maxPre.next = maxNow.next;
            maxNow.next = nowPre.next;
            nowPre.next = maxNow;
            nowPre = nowPre.next;
        }
        return nowHead.next;
    }
}
