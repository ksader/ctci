package org.saderfamily.ch4;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    public Node[] nodes;

    /**
     * Finds if a path can be made from src to dest
     * @param src non-null
     * @param dest non-null
     * @return Node found in graph
     */
    public Node pathExists(Node src, Node dest) {
        if(src.name.equals(dest.name)) {
            return src;
        }

        for (Node child: src.children) {
            Node result = pathExists(child, dest);
            if(result != null) {
                return result;
            }
        }

        return null;
    }

}
