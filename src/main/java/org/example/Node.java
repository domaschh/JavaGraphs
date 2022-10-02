package org.example;

import java.util.UUID;

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

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceToSource() {
        return distanceToSource;
    }

    public void setDistanceToSource(int distanceToSource) {
        this.distanceToSource = distanceToSource;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distanceToSource, node.getDistanceToSource());
    }
}
