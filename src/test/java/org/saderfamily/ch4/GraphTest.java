package org.saderfamily.ch4;

import org.testng.annotations.*;
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

        s.children = new Node[]{a, z};
        a.children = new Node[]{n, m};
        n.children = new Node[]{i};
        m.children = new Node[]{e};

        directedGraph = new Graph();
        directedGraph.nodes = new Node[]{s};
    }

    @Test
    public void pathExists() {
        assertNotNull(directedGraph.pathExists(s, e));
    }

    @Test
    public void noPathExists() {
        assertNull(directedGraph.pathExists(a, z));
    }
}
