package easy.link;

import util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoSortedLists_21
{
    public static void main(String[] args)
    {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode nList;
        ListNode nEnd;
        ListNode list1 = l1;
        ListNode list2 = l2;
        if (list1.val < list2.val) {
            nList = list1;
            list1 = list1.next;
        }
        else {
            nList = list2;
            list2 = list2.next;
        }
        nEnd = nList;
        nEnd.next = null;
        while (true) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    nEnd.next = list1;
                    nEnd = list1;
                    list1 = list1.next;
                    nEnd.next = null;
                }
                else {
                    nEnd.next = list2;
                    nEnd = list2;
                    list2 = list2.next;
                    nEnd.next = null;
                }
            }
            else if (list1 == null) {
                nEnd.next = list2;
                return nList;
            }
            else {
                nEnd.next = list1;
                return nList;
            }
        }
    }
}
