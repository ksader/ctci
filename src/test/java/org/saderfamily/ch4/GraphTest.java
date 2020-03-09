package org.saderfamily.ch4;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class GraphTest {
    private Graph directedWithPath;
    private Node a;
    private Node e;
    private Node i;
    private Node m;
    private Node n;
    private Node s;

    @BeforeTest
    public void setup() {
        directedWithPath = new Graph();
        a = new Node("a");
        e = new Node("e");
        i = new Node("i");
        m = new Node("m");
        n = new Node("n");
        s = new Node("s");

        s.children = new Node[]{a};
        a.children = new Node[]{n, m};
        n.children = new Node[]{i};
        m.children = new Node[]{e};

        directedWithPath.nodes = new Node[]{s};
    }

    @Test
    public void pathExists() {
        assertNotNull(directedWithPath.pathExists(s, e));
    }
}
