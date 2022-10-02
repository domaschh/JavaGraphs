package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphBuilder {
    private Map<Node, List<Edge>> nodesInGraph =  new HashMap<>();
    public GraphBuilder() {}

    public GraphBuilder nodeWithoutAdjacent(Node node) {
        this.nodesInGraph.put(node, new ArrayList<>());
        return this;
    }

    public GraphBuilder node(Node node, List<Edge> edges) {
        this.nodesInGraph.put(node, edges);
        return this;
    }

    public Graph build() {
        return new Graph(this.nodesInGraph);
    }

}
