package org.example;

public class Edge implements Comparable<Edge> {

    private Node node;
    private int cost;

    public Edge(Node node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public Edge() {}

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "(" +node + "," + cost + ")";
    }

    @Override
    public int compareTo(Edge edgeToCompare) {
        return Integer.compare(this.cost, edgeToCompare.getCost());
    }
}
