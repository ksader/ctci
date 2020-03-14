package org.saderfamily.ch4;

public class Node {
    public Node(String name) {
        this.name = name;
        children = new Node[]{};
    }

    public Node(int number) {
        this.number = number;
    }

    public String name;
    public Node[] children;

    // For BST exercise
    public int number;
    public Node left;
    public Node right;

    public static Node createBST(int[] sorted, int startIndex, int endIndex) {
        if(null == sorted || sorted.length == 0 || endIndex < startIndex) {
            return null;
        }

        int midpoint = (startIndex + endIndex) / 2;

        Node node = new Node(sorted[midpoint]);

        if(midpoint > startIndex) {
            node.left = createBST(sorted, startIndex, midpoint - 1);
        }

        if(midpoint < endIndex) {
            node.right = createBST(sorted, midpoint + 1, endIndex);
        }

        return node;
    }
}
