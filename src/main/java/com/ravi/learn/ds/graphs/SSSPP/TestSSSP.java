package com.ravi.learn.ds.graphs.SSSPP;

import com.ravi.learn.ds.graphs.graphRepresentation.Vertex;

import java.util.ArrayList;
import java.util.List;

public class TestSSSP {
    public static void main(String[] args) throws Exception{
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

        //Weighted Test For Dijkastras
        //      B --3----> E
        //    /' \      1/' \9
        //  /2    \ 1 /      \,
        // A       'D        G
        //  \5             7/'
        //   \,           /
        //     C --8---> F
        //
        //
        MyGraph testDijkastras = new MyGraph(vertices, MyGraph.MyGraphType.DIRECTED);
        testDijkastras.addWeightedEdge(a, b, 2);
        testDijkastras.addWeightedEdge(a, c, 5);
        testDijkastras.addWeightedEdge(b, e, 3);
        testDijkastras.addWeightedEdge(b, d, 1);
        testDijkastras.addWeightedEdge(c, f, 8);
        testDijkastras.addWeightedEdge(d, e, 1);
        testDijkastras.addWeightedEdge(e, g, 9);
        testDijkastras.addWeightedEdge(f, g, 7);
        testDijkastras.displayGraph();
        testDijkastras.sssp();

        //Bellman Ford & Dijkastras -ve Weighted graph :
        // A<----3----B ,
        // |  '\     '|' \4
        // |6    \-6  |1  \
        //,|       \  |   / E
        // C'----1--->D ,/2
        //   <--- 2----

        List<Vertex> negativeCycleTestVerticesList = new ArrayList<>();
        negativeCycleTestVerticesList.add(e);
        negativeCycleTestVerticesList.add(b);
        negativeCycleTestVerticesList.add(c);
        negativeCycleTestVerticesList.add(d);
        negativeCycleTestVerticesList.add(a);
        MyGraph testNegativeWeightGraph = new MyGraph(negativeCycleTestVerticesList, MyGraph.MyGraphType.DIRECTED);
        testNegativeWeightGraph.addWeightedEdge(b, a, 3);
        testNegativeWeightGraph.addWeightedEdge(a, c, 6);
        testNegativeWeightGraph.addWeightedEdge(c, d, 1);
        testNegativeWeightGraph.addWeightedEdge(d, c, 2);
        testNegativeWeightGraph.addWeightedEdge(d, a, -6);
        testNegativeWeightGraph.addWeightedEdge(d, b, 1);
        testNegativeWeightGraph.addWeightedEdge(e, b, 4);
        testNegativeWeightGraph.addWeightedEdge(e, d, 2);
        testNegativeWeightGraph.displayGraph();
        testNegativeWeightGraph.sssp();

        //Dijkastras and Bellman Ford test -ve cycle Graph
        // A<----3----B ,
        // |  \      '|' \4
        // |6    \-6  |1  \
        //,|       \, |   / E
        // C'----1--->D ,/2
        //   <--- 2----
        MyGraph testNegativeCycleGraph = new MyGraph(negativeCycleTestVerticesList, MyGraph.MyGraphType.DIRECTED);
        testNegativeCycleGraph.addWeightedEdge(b, a, 3);
        testNegativeCycleGraph.addWeightedEdge(a, c, 6);
        testNegativeCycleGraph.addWeightedEdge(c, d, 1);
        testNegativeCycleGraph.addWeightedEdge(d, c, 2);
        testNegativeCycleGraph.addWeightedEdge(a, d, -6);
        testNegativeCycleGraph.addWeightedEdge(d, b, 1);
        testNegativeCycleGraph.addWeightedEdge(e, b, 4);
        testNegativeCycleGraph.addWeightedEdge(e, d, 2);
        testNegativeCycleGraph.displayGraph();
        testNegativeCycleGraph.sssp();
    }
}
