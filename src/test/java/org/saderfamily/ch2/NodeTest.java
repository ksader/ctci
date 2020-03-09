package org.saderfamily.ch2;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class NodeTest {
    private Node duplicateSLL;

    @BeforeTest
    public void setup() {
        Node duplicateSLL = new Node(1);

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

}