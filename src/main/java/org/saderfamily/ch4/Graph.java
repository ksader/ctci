package org.saderfamily.ch4;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    public Node[] nodes;

    public Node pathExists(Node src, Node dest) {
        if(null == src) {
            return null;
        }

        if(src.name.equals(dest.name)) {
            return src;
        }

        Node result = null;
        for (Node child: src.children) {
            if(result == null) {
                result = pathExists(child, dest);
                if(result != null) {
                    return result;
                }
            }
        }

        return result;
    }

}
