package com.ravi.learn.ds.graphs.graphRepresentation;

public class Edge {
    private Vertex source;
    private Vertex destination;
    private Float weight;

    public Edge(Vertex source, Vertex destination, float weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }


    /**
     * Used for creating unweighted graph
     * @param source
     * @param destination
     */
    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;

    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public Float getWeight() {
        return (null == weight) ? null : weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        if (null == weight) {
            return this.getSource().getName() + " ----->" + this.getDestination().getName();
        } else {
            return this.getSource().getName() + " --- " + this.getWeight() + " -->" + this.getDestination().getName();
        }
    }

}
