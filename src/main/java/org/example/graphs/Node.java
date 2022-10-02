package org.example.graphs;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Node implements Comparable<Node> {
    private UUID id;
    private String name;
    private int distanceToSource = Integer.MAX_VALUE;
    private Node previousNode = null;

    public Node(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + distanceToSource + ")" + "(" + previousNode + ")";
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distanceToSource, node.getDistanceToSource());
    }
}
