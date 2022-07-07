package com.ravi.learn.ds.graphs.graphRepresentation;

public class Vertex implements Comparable<Vertex> {
    private String name;
    private float distanceFromSource;
    private Vertex pathVia;

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

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

    @Override
    public int compareTo(Vertex otherVertex) {
        float diff = this.distanceFromSource - otherVertex.getDistanceFromSource();
        if (diff<0) return -1;
        if (diff>0) return 1;
        return 0;
    }
}
