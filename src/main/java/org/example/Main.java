package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var berlin = new Node("Berlin");
        var frankfurt = new Node("Frankfurt");
        var muenchen = new Node("Muenchen");
        var graz = new Node("Graz");
        var linz = new Node("Linz");
        var wien = new Node("Wien");
        var triest = new Node("Triest");
        var rom = new Node("Rom");

        var graph = new GraphBuilder()
                //.node(berlin, new ArrayList(Arrays.asList(frankfurt)))
               // .node(frankfurt, new ArrayList(Arrays.asList(berlin, muenchen)))
                //.node(muenchen, new ArrayList(Arrays.asList(frankfurt, graz, linz)))
                .node(graz, new ArrayList(Arrays.asList(new Edge(wien,2), new Edge(muenchen,3), new Edge(triest,3))))
                .node(linz, new ArrayList(Arrays.asList(new Edge(wien, 2), new Edge(muenchen,2))))
                .node(wien, new ArrayList(Arrays.asList(new Edge(graz, 2), new Edge(linz,2))))
                .node(triest, new ArrayList(Arrays.asList(new Edge(graz, 3), new Edge(rom,5))))
                .node(rom, new ArrayList(Arrays.asList(new Edge(triest,5))))
                .build();

        graph.printGraph();
        System.out.println("=========================================================");

        var stpoelten = new Node("St Poelten");
        var klagenfurt = new Node("Klagenfurt");

        graph.insertNodeBetween(stpoelten, linz, wien);

        graph.printGraph();
        System.out.println("=========================================================");
        graph.insertNodeBetween(klagenfurt, new ArrayList<>(Arrays.asList(triest, graz)), new ArrayList<>(Arrays.asList(1,1)));
        graph.printGraph();




        System.out.println("=========================================================");
        var a =  new Node("A");
        var b =  new Node("B");
        var c =  new Node("C");
        var d =  new Node("D");
        var e =  new Node("E");
        var f =  new Node("F");


        var djkstraGraph = new GraphBuilder()
                .node(a, new ArrayList<>(Arrays.asList(new Edge(b, 2), new Edge(c,3), new Edge(d, 4))))
                .node(b, new ArrayList<>(Arrays.asList(new Edge(e, 8))))
                .node(c, new ArrayList<>(Arrays.asList(new Edge(e,9))))
                .node(d, new ArrayList<>(Arrays.asList(new Edge(f,4))))
                .node(e, new ArrayList<>(Arrays.asList(new Edge(f,1))))
                .node(f, new ArrayList<>(Arrays.asList()))
                .build();


        var shortestPathTable = djkstraGraph.djikstra(a);
        System.out.println("-----------------" );
        shortestPathTable.forEach(node -> {
            System.out.println("Node and shortest path = " + node);
        });
    }
}