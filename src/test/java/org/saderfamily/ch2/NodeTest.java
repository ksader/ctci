package org.saderfamily.ch2;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class NodeTest {
    private Node duplicateSLL;

    @BeforeTest
    public void setup() {
        duplicateSLL = new Node(1);

        duplicateSLL.append(2);
        duplicateSLL.append(1);
        duplicateSLL.append(1);
        duplicateSLL.append(1);
        duplicateSLL.append(1);
        duplicateSLL.append(3);
        duplicateSLL.append(1);
        duplicateSLL.append(2);
        duplicateSLL.append(4);
        duplicateSLL.append(3);
    }

    @Test
    public void remove_duplicate_nodes() {
        Map<Integer, Integer> duplicates = new HashMap<>();
        Node current = duplicateSLL;
        do {
            if(null == duplicates.get(current.number)) {
                duplicates.put(current.number, 1);
            } else {
                duplicates.put(current.number, duplicates.get(current.number) + 1);
            }
            current = current.next;
        } while(current.next != null);

        //  Assess the last node
        if(null == duplicates.get(current.number)) {
            duplicates.put(current.number, 0);
        } else {
            duplicates.put(current.number, duplicates.get(current.number) + 1);
        }

        Node head = duplicateSLL;
        for (Integer key : duplicates.keySet()) {
            if(duplicates.get(key) > 0) {
                for(int i = 0; i < duplicates.get(key) - 1; ++i) {
                    head = Node.deleteNode(head, key);
                }
            }
        }

        // Assume one current node to account for last null check
        int numNodes = 1;
        while(head.next != null) {
            numNodes++;
            head = head.next;
        }

        assertEquals(numNodes, 4);
    }

    @DataProvider
    Object [][] kthNode() {
        return new Object[][] {
                {1, 4},
                {2, 2},
                {3, 1},
                {4, 3},
                {5, 1},
                {6, 1},
                {7, 1},
                {8, 1},
                {9, 2}
        };
    }
    @Test(dataProvider = "kthNode")
    // The hints in the book ask "What if you know the size and can you do this recursively?
    // If I knew the size, I'd assume an array implementation and make my life a lot easier. In the default
    // Node impl, there's no size - I suppose I could add that data item but then there might be threading issues.
    // OTOH, I went straight to the dual pointer implementation as per the last suggestion.
    public void find_kth_to_last_element(int kth, int expected) {
        int k = kth;
        int current = 0;
        // see to head by default
        Node kthLast = duplicateSLL;
        Node currentNode = duplicateSLL;

        while (currentNode.next != null) {
            if(current >= k) {
                kthLast = kthLast.next;
            }
            current++;
            currentNode = currentNode.next;
        }

        assertEquals(kthLast.number, expected);
    }
}