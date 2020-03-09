package org.saderfamily.ch4;

public class Node {
    public Node(String name) {
        this.name = name;
        children = new Node[]{};
    }

    public String name;
    public Node[] children;
}
