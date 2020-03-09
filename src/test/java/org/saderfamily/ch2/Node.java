package org.saderfamily.ch2;

/**
 * Basic Node class for a singly linked list
 */
public class Node {
    Node next = null;
    int number;

    public Node(int num) {
        this.number = num;
    }

    void append(int num) {
        Node end = new Node(num);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    static Node deleteNode(Node head, int value) {
        if(head == null) {
            return null;
        }
        Node currentNode = head;
        if(currentNode.number == value) {
            return head.next;
        }

        while(currentNode.next != null) {
            if(currentNode.next.number == value) {
                currentNode.next = currentNode.next.next;
                return head;
            }
            currentNode = currentNode.next;
        }

        return head;
    }
}
