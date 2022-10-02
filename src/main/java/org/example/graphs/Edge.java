package org.example.graphs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Edge implements Comparable<Edge> {

    private Node node;
    private int cost;

    @Override
    public String toString() {
        return "(" +node + "," + cost + ")";
    }

    @Override
    public int compareTo(Edge edgeToCompare) {
        return Integer.compare(this.cost, edgeToCompare.getCost());
    }
}
