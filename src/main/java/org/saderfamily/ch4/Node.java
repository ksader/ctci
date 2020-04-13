package org.saderfamily.ch4;

import java.util.*;

public class Node {
    private String name;
    private Node[] children;
    // For BST exercise
    private int number;

    Node(Node[] children) {
        setChildren(children);
    }
    public Node(String name) {
        this(new Node[]{});
        this.setName(name);
    }

    public Node(int number) {
        this(new Node[]{});
        this.setNumber(number);
    }

    public static Node createBST(int[] sorted, int startIndex, int endIndex) {
        if(null == sorted || sorted.length == 0 || endIndex < startIndex) {
            return null;
        }

        int midpoint = (startIndex + endIndex) / 2;

        Node node = new Node(sorted[midpoint]);

        if(midpoint > startIndex) {
            node.setLeft(createBST(sorted, startIndex, midpoint - 1));
        }

        if(midpoint < endIndex) {
            node.setRight(createBST(sorted, midpoint + 1, endIndex));
        }

        return node;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node getLeft() {
        if(null == children || children.length != 2) {
            return null;
        }
        return children[0];
    }

    public void setLeft(Node left) {
        initStorage();
        this.children[0] = left;
    }

    public Node getRight() {
        if(null == children || children.length != 2) {
            return null;
        }

        return children[1];
    }

    public void setRight(Node right) {
        initStorage();
        this.children[1] = right;
    }

    private void initStorage() {
        if (this.children.length == 0) {
            this.children = new Node[2];
        }
    }

    public int nodeDepth(Node tree, int value) {
        if(null == tree) {
            return 0;
        }

        if(tree.getNumber() == value) {
            return 0;
        }

        if(value < tree.getNumber()) {
            return 1 + nodeDepth(tree.getLeft(), value);
        }

        if(value > tree.getNumber()) {
            return 1 + nodeDepth(tree.getRight(), value);
        }

        return -1;
    }

    public List<List<Node>> listLevels(Node root) {
        Queue<Node> visitees = new LinkedList<>();
        Set<Node> marked = new HashSet<>();
        marked.add(root);
        visitees.add(root);

        List<List<Node>> levelLists = new ArrayList<>();
        while(!visitees.isEmpty()) {
            Node visiting = visitees.remove();

            // Visit...
            assignNodeLevel(root, levelLists, visiting);

            // Traverse
            for(Node n : visiting.getChildren()) {
                if(null != n && !marked.contains(n)) {
                    marked.add(n);
                    visitees.add(n);
                }
            }
        }

        return levelLists;
    }

    void assignNodeLevel(Node root, List<List<Node>> levelLists, Node visiting) {
        int nodeDepth = nodeDepth(root, visiting.getNumber());
        if(levelLists.size() < nodeDepth + 1) {
            List<Node> level = new ArrayList<>();
            level.add(visiting);
            levelLists.add(nodeDepth, level);
        } else {
            levelLists.get(nodeDepth).add(visiting);
        }
    }
}
