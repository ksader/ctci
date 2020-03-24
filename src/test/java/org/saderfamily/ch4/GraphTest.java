package org.saderfamily.ch4;

import org.testng.annotations.*;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

public class GraphTest {
    private Graph directedGraph;
    private Node a;
    private Node e;
    private Node i;
    private Node m;
    private Node n;
    private Node s;
    private Node z;

    @BeforeTest
    public void setup() {
        a = new Node("a");
        e = new Node("e");
        i = new Node("i");
        m = new Node("m");
        n = new Node("n");
        s = new Node("s");
        z = new Node("z");

        s.setChildren(new Node[]{a, z});
        a.setChildren(new Node[]{n, m});
        n.setChildren(new Node[]{i});
        m.setChildren(new Node[]{e});

        directedGraph = new Graph();
        directedGraph.nodes = new Node[]{s};
    }

    @Test(description = "Exercise 4.1")
    public void pathExists() {
        assertNotNull(directedGraph.pathExists(s, e));
    }

    @Test
    public void noPathExists() {
        assertNull(directedGraph.pathExists(a, z));
    }

    @Test(description = "Exercise 4.2")
    public void createBSTFromSortedArray() {
        int[] sortedArray = new int[]{1, 2, 3, 5, 8, 13, 21, 34};

        Node tree =  Node.createBST(sortedArray, 0, sortedArray.length - 1);

        assertEquals(tree.getNumber(), 5);
        assertEquals(tree.getLeft().getLeft().getNumber(), 1);
        assertEquals(tree.getLeft().getRight().getNumber(), 3);

        assertEquals(tree.getRight().getNumber(), 13);
        assertEquals(tree.getRight().getLeft().getNumber(), 8);
        assertEquals(tree.getRight().getLeft().getLeft(), null);
        assertEquals(tree.getRight().getLeft().getRight(), null);
        assertEquals(tree.getRight().getRight().getLeft(), null);
        assertEquals(tree.getRight().getRight().getRight().getNumber(), 34);
    }

    @Test(description = "Exercise 4.3")
    public void list_depths() {
        List<Node> depthNodes = new LinkedList<>();


    }
}
