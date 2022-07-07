package com.ravi.learn.ds.graphs.graphRepresentation;

public class Vertex {
    private String name;
    private float distanceFromSource;
    private Vertex pathVia;
    private boolean isVisited;

    public Vertex(String name) {
        this.name = name;
        this.distanceFromSource = Float.MAX_VALUE;
    }

    public void visit() {
        isVisited = true;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public String getName() {
        return  this.name;
    }

    public float getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(float distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public Vertex getPathVia() {
        return pathVia;
    }

    public void setPathVia(Vertex pathVia) {
        this.pathVia = pathVia;
    }
}
