package hard.link;

import util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists
{
    public static void main(String[] args)
    {
    }

    public ListNode mergeKListsPriority(ListNode[] lists)
    {
        List<ListNode> listAll = new ArrayList<>();
        for (ListNode nodeList : lists) {
            if (nodeList != null) {
                listAll.add(nodeList);
            }
        }
        if (listAll.size() == 0) {
            return null;
        }
        else if (listAll.size() == 1) {
            return listAll.get(0);
        }
        else {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
            for (ListNode listNode : listAll) {
                queue.add(listNode);
            }
            ListNode head = null;
            ListNode end = null;
            while (!queue.isEmpty()) {
                ListNode temp = queue.poll();
                if (head == null) {
                    head = temp;
                    temp = temp.next;
                    head.next = null;
                    end = head;
                }
                else {
                    end.next = temp;
                    end = end.next;
                    temp = temp.next;
                    end.next = null;
                }
                if (temp != null) {
                    queue.add(temp);
                }
            }
            return head;
        }
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        List<ListNode> listAll = new ArrayList<>();
        for (ListNode nodeList : lists) {
            if (nodeList != null) {
                listAll.add(nodeList);
            }
        }
        if (listAll.size() == 0) {
            return null;
        }
        else if (listAll.size() >= 2) {
            ListNode merge = listAll.get(0);
            for (int i = 1; i < listAll.size(); i++) {
                ListNode list1 = listAll.get(i);
                merge = mergeTwoLists(merge, list1);
            }
            return merge;
        }
        else {
            return listAll.get(0);
        }
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
