package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Graph implements Cloneable {

    public Map<Node, List<Edge>> nodesInGraph;

    public Graph(Map<Node, List<Edge>> edges) {
        this.nodesInGraph = edges;
    }

    public void insertNodeBetween(Node newNode, Node... nodes) {
        //insert the node itself with all its neighbors, so you can travel there
        var edges = Arrays.stream(nodes).map(node -> new Edge(node, 1)).toList();

        this.nodesInGraph.put(newNode, new ArrayList<Edge>(edges));

        //now check all the nodes and add the new node as adjacent
        for (Node adjacent : nodes) {
            var edgesOfNode = this.nodesInGraph.get(adjacent);

            edgesOfNode.add(new Edge(newNode, 1));

            var edgesToRemove = edgesOfNode.stream().filter(edge -> Arrays.stream(nodes).anyMatch(node -> edge.getNode().equals(node))).toList();

            edgesOfNode.removeAll(edgesToRemove);
        }
    }

    public Set<Node> djikstra(Node sourceNode) {
        var unvisitedNodes = new PriorityQueue<Node>();
        Set<Node> shortestPathTable = new HashSet<>();

        //Add all nodes and set start node distance to 0
        sourceNode.setDistanceToSource(0);
        unvisitedNodes.addAll(this.nodesInGraph.keySet());
        shortestPathTable.addAll(this.nodesInGraph.keySet());


        while (!unvisitedNodes.isEmpty()) {
            var currentNode = unvisitedNodes.poll();

            var connectedNodes = this.nodesInGraph.get(currentNode);
            if (connectedNodes.isEmpty()) continue;

            for (Edge connectedNode : connectedNodes) {
                var calculatedPathCost = (currentNode.getDistanceToSource() + connectedNode.getCost());

                if (connectedNode.getNode().getDistanceToSource() > calculatedPathCost) {
                    connectedNode.getNode().setDistanceToSource(calculatedPathCost);
                    connectedNode.getNode().setPreviousNode(currentNode);
                }

                shortestPathTable.add(connectedNode.getNode());
            }
        }

        return shortestPathTable;
    }
    public void insertNodeBetween(Node newNode, List<Node> nodes, List<Integer> edgeWeights) {

        //insert the node itself with all its neighbors, so you can travel there
        var edges = IntStream.range(0,nodes.size()).mapToObj(index -> new Edge(nodes.get(index), edgeWeights.get(index))).toList();

        this.nodesInGraph.put(newNode, new ArrayList<Edge>(edges));

        //now check all the nodes and add the new node as adjacent
        for (int idx = 0; idx < nodes.size(); idx++) {
            Node adjacent = nodes.get(idx);
            var edgesOfNode = this.nodesInGraph.get(adjacent);

            edgesOfNode.add(new Edge(newNode, edgeWeights.get(idx)));

            var edgesToRemove = edgesOfNode.stream().filter(edge -> nodes.stream().anyMatch(node -> edge.getNode().equals(node))).toList();

            edgesOfNode.removeAll(edgesToRemove);
        }
    }

    @Override
    public String toString() {
        return "Graph{" + "nodes=" + nodesInGraph + '}';
    }

    public void printGraph() {
        this.nodesInGraph.forEach((node, edges) -> {
            System.out.println(node + "" + edges);
        });
    }
}
