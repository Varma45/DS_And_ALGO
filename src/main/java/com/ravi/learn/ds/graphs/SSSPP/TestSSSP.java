package com.ravi.learn.ds.graphs.SSSPP;

import com.ravi.learn.ds.graphs.graphRepresentation.Vertex;

import java.util.ArrayList;
import java.util.List;

public class TestSSSP {
    public static void main(String[] args) {
        // UnDirected Unweighted Graph
        //  A ------- B
        //  |          |  \
        //  C ------- D     G
        //  |          |  /
        //  E ------- F
        //

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);

        MyGraph testMyGraph = new MyGraph(vertices, MyGraph.MyGraphType.UNDIRECTED);
        testMyGraph.addUnWeightedEdge(a, b);
        testMyGraph.addUnWeightedEdge(a, c);
        testMyGraph.addUnWeightedEdge(b, d);
        testMyGraph.addUnWeightedEdge(c, d);
        testMyGraph.addUnWeightedEdge(b, g);
        testMyGraph.addUnWeightedEdge(f, g);
        testMyGraph.addUnWeightedEdge(c, e);
        testMyGraph.addUnWeightedEdge(e, f);
        testMyGraph.addUnWeightedEdge(d, f);

        testMyGraph.displayGraph();
        testMyGraph.bfs();
        testMyGraph.sssp();

    }
}
