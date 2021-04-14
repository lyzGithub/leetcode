package hard.link;

import util.ListNode;

public class ReverseNodesInKgroup
{
    public static void main(String[] args)
    {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        new ReverseNodesInKgroup().reverseKGroup(node1, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k)
    {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        ListNode jumper = head;

        while (jumper != null) {
            ListNode jumperTemp = jumper;
            for (int i = 0; i < k; i++) {
                if (jumper != null) {
                    jumper = jumper.next;
                }
                else {
                    newTail.next = jumperTemp;
                    ListNode realHead = newHead.next;
                    newHead.next = null;
                    return realHead;
                }
            }
            jumper = jumperTemp;
            for (int i = 0; i < k; i++) {
                if (jumper != null) {
                    ListNode temp = jumper.next;
                    jumper.next = newTail.next;
                    newTail.next = jumper;
                    jumper = temp;
                }
            }
            for (int i = 0; i < k; i++) {
                newTail = newTail.next;
            }
        }
        ListNode realHead = newHead.next;
        newHead.next = null;
        return realHead;
    }
}
