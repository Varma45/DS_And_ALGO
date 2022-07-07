package com.ravi.learn.ds.graphs.SSSPP;

import com.ravi.learn.ds.graphs.graphRepresentation.Edge;
import com.ravi.learn.ds.graphs.graphRepresentation.Vertex;

import java.util.*;


public class MyGraph {

    enum MyGraphType {
        DIRECTED,
        UNDIRECTED;
    }

    private List<Vertex> vertices = new ArrayList<>();
    private Map<String, List<Edge>> edgesListMap = new HashMap<>();
    private MyGraphType graphType;
    private boolean isWeighted;

    public MyGraph(List vertices, MyGraphType graphType) {
        this.vertices = vertices;
        this.graphType = graphType;
    }

    public void addWeightedEdge(Vertex source, Vertex destination, float weight) {
        isWeighted = true;
        if (graphType.equals(MyGraphType.DIRECTED)) {
            addEdgeToEdgesList(source, destination, weight);
        } else {
            addEdgeToEdgesList(source, destination, weight);
            addEdgeToEdgesList(destination, source, weight);
        }
    }

    private void addEdgeToEdgesList(Vertex source, Vertex destination, Float weight) {
        Edge e;
        if (null == weight) {
            e = new Edge(source, destination);
        } else {
            e = new Edge(source, destination, weight);
        }
        List<Edge> edgesWithSrcVertex = edgesListMap.get(source.getName());
        if (null == edgesWithSrcVertex) {
            edgesWithSrcVertex = new ArrayList<>();
        }
        edgesWithSrcVertex.add(e);
        edgesListMap.put(source.getName(), edgesWithSrcVertex);
    }

    public void addUnWeightedEdge(Vertex source, Vertex destination) {
        if (graphType.equals(MyGraphType.DIRECTED)) {
            addEdgeToEdgesList(source, destination, null);
        } else {
            addEdgeToEdgesList(source, destination, null);
            addEdgeToEdgesList(destination, source, null);
        }
    }

    public void displayGraph() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v : vertices) {
            List<Edge> edgesOfV = edgesListMap.get(v.getName());
            sb.append("\nEdges With " + v.getName() + " : ");
            for (Edge e : edgesOfV) {
                sb.append("  "+e.toString());
            }
        }
        System.out.println(sb.toString());
    }

    public void sssp() {
        if (!isWeighted) {
            bfs();
            System.out.println("Single Source Shortest Path from :" + vertices.get(0).getName());
            for (Vertex v : vertices) {
                System.out.print(v.getName() + " : ");
                printSSSPath(v);
                System.out.println();
            }
        }
    }

    private void printSSSPath(Vertex v) {
        if (v.getPathVia() == null) {
            System.out.print(v.getName());
            return;
        } else {
            printSSSPath(v.getPathVia());
            System.out.print(" ----> " + v.getName());
        }

    }

    public void bfs() {
        Queue<Vertex> trackVertices = new LinkedList<>();
        for (Vertex v : vertices) {
            if (!v.isVisited()) {
                v.setPathVia(null);
                trackVertices.add(v);
                bfsTraversal(trackVertices);
            }
        }
    }

    private void bfsTraversal(Queue<Vertex> trackVertices) {
        StringBuilder sb = new StringBuilder();

        while(!trackVertices.isEmpty()) {
            Vertex currentNode = trackVertices.remove();
            sb.append( currentNode.getName() + " ---> ");
            currentNode.visit();
            List<Edge> edgeList = edgesListMap.get(currentNode.getName());
            for (Edge edge : edgeList) {
                if (!edge.getDestination().isVisited()){
                    trackVertices.add(edge.getDestination());
                    edge.getDestination().visit();
                    edge.getDestination().setPathVia(currentNode);
                }
            }
        }
        sb.append(" END\n");
        System.out.println(sb.toString());
    }


}
