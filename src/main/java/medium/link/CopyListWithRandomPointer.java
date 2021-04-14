package medium.link;

import util.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer
{
    public static void main(String[] args)
    {
    }

    public Node copyRandomList1(Node head)
    {
        // additional O(n), time O(n)
        Map<Node, Node> relatedMap = new HashMap<>();
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Node nowNode = newHead;
        relatedMap.put(head, newHead);
        Node preHead = head.next;
        while (preHead != null) {
            Node temp = new Node(preHead.val);
            nowNode.next = temp;
            nowNode = temp;
            relatedMap.put(preHead, temp);
            preHead = preHead.next;
        }
        preHead = head;
        while (preHead != null) {
            if (preHead.random != null) {
                Node temp1 = relatedMap.get(preHead);
                Node temp2 = relatedMap.get(preHead.random);
                temp1.random = temp2;
            }
            preHead = preHead.next;
        }
        return newHead;
    }

    public Node copyRandomList2(Node head)
    {
        // additional mem O(1), time O(n)
        if (head == null) {
            return null;
        }
        Node preHead = head;
        while (preHead != null) {
            Node newNode = new Node(preHead.val);
            newNode.random = preHead.random;
            newNode.next = preHead.next;
            preHead.next = newNode;
            preHead = preHead.next.next;
        }
        preHead = head;
        while (preHead != null) {
            if (preHead.random != null) {
                preHead.next.random = preHead.random.next;
            }
            preHead = preHead.next.next;
        }
        Node newHead = head.next;
        Node newTail = newHead;
        preHead = head;
        while (preHead != null) {
            preHead.next = newTail.next;
            preHead = preHead.next;
            if (preHead != null) {
                newTail.next = preHead.next;
                newTail = preHead.next;
            }
        }
        return newHead;
    }
}
