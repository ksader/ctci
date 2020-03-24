package org.saderfamily.ch4;


public class Graph {
    public Node[] nodes;

    /**
     * Finds if a path can be made from src to dest
     * @param src non-null
     * @param dest non-null
     * @return Node found in graph
     */
    public Node pathExists(Node src, Node dest) {
        if(src.getName().equals(dest.getName())) {
            return src;
        }

        for (Node child: src.getChildren()) {
            Node result = pathExists(child, dest);
            if(result != null) {
                return result;
            }
        }

        return null;
    }

}
