package com.ravi.learn.ds.graphs;
import java.util.*;

public class MyGraph2 {

    public enum GraphRepresentationType{
        ADJACENCY_MATRIX,
        ADJACENCY_LIST;
    }

    List<GraphNode2> nodeList;
    int[][] adjacencyMatrix ;
    List<List<Integer>> adjacencyList;
    private GraphRepresentationType graphRepresentationType;

    public MyGraph2(List nodeList, GraphRepresentationType graphRepresentationType) {
        this.nodeList = nodeList;
        this.graphRepresentationType = graphRepresentationType;
        if (isAdjacencyMatrixRepresentation()) {
            initializeAdjacencyMatrix();
        }
        if (isAdjacencyListRepresentation()) {
            initializeAdjacencyList();
        }
    }

    private void initializeAdjacencyList() {
        adjacencyList = new ArrayList<>();
    }

    private void initializeAdjacencyMatrix() {
        if (nodeList.size() > 0 ) {
            adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
        }
    }

    public void addUndirectedEdge(int indexOfNode1, int[] connectedNodes) {
        if (isAdjacencyMatrixRepresentation()) {
            for (int i : connectedNodes) {
                adjacencyMatrix[indexOfNode1][i] = 1;
                adjacencyMatrix[i][indexOfNode1] = 1;
            }

        }
        if (isAdjacencyListRepresentation()) {
            List<Integer> connectedNodesList = new ArrayList<>();
            connectedNodesList.add(indexOfNode1);
            for (int i : connectedNodes) {
                connectedNodesList.add(i);
            }
            adjacencyList.add(connectedNodesList);
        }
    }

    private boolean isAdjacencyListRepresentation() {
        return this.graphRepresentationType.equals(GraphRepresentationType.ADJACENCY_LIST);
    }

    private boolean isAdjacencyMatrixRepresentation() {
        return this.graphRepresentationType.equals(GraphRepresentationType.ADJACENCY_MATRIX);
    }

    public void addDirectedEdge(int indexOfSrcNode, int[] indicesOfDestNodes) {
        if (isAdjacencyMatrixRepresentation()) {
            for (int indexOfDestNode : indicesOfDestNodes)
            adjacencyMatrix[indexOfSrcNode][indexOfDestNode] = 1;
        }
    }

    public void displayGraph() {
        if (isAdjacencyMatrixRepresentation()) displayGraphAsMatrix();
        if (isAdjacencyListRepresentation()) displayGraphAsList();
    }

    private void displayGraphAsMatrix() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        for (GraphNode2 node : nodeList) {
            sb.append(node.getNodeName() + "\t");
        }
        for (int i = 0 ; i < adjacencyMatrix.length; i++) {
            sb.append("\n");
            sb.append(nodeList.get(i).getNodeName() + "\t");
            for (int j = 0 ; j < adjacencyMatrix.length; j++) {
                sb.append(adjacencyMatrix[i][j] + "\t");
            }
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }

    private void displayGraphAsList() {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> connectedNodeList : adjacencyList ) {
            int srcNodeIndex = connectedNodeList.get(0);
            String srcNodeName = nodeList.get(srcNodeIndex).getNodeName();
            sb.append( srcNodeName+ " -> ");
            for (int i = 1; i < connectedNodeList.size(); i++) {
                String destNode = nodeList.get(connectedNodeList.get(i)).getNodeName();
                sb.append(destNode + " , ");
            }
            sb.append("END" + "\n");
        }
        System.out.println(sb.toString());
    }

    public void bfs() {
        Queue<GraphNode2> nodeQueue = new LinkedList<>();
        GraphNode2 startNode = this.nodeList.get(0);
        nodeQueue.add(startNode);
        while (!nodeQueue.isEmpty()) {
            GraphNode2 currentNode = nodeQueue.remove();
            System.out.print(currentNode.visit() + " -> ");
            List<GraphNode2> neighbourNodes = getNeighbours(currentNode);
            for (GraphNode2 node : neighbourNodes) {
                if(!node.isVisited()) {
                    nodeQueue.add(node);
                    node.visit();
                }
            }
        }
        System.out.print("END\n");
    }

    private List<GraphNode2> getNeighbours(GraphNode2 node) {
        List<GraphNode2> neighbourNodes = new ArrayList<>();
        int index = node.getIndex();
        for (int j = 0 ; j < this.adjacencyMatrix.length; j++) {
            if (adjacencyMatrix[index][j] == 1) {
                neighbourNodes.add(nodeList.get(j));
            }
        }
        return neighbourNodes;
    }

    public void dfs() {
        GraphNode2 startNode = nodeList.get(0);
        Stack<GraphNode2> nodeStack = new Stack<>();
        nodeStack.push(startNode);
        while(!nodeStack.isEmpty()) {
            GraphNode2 current = nodeStack.pop();
            System.out.print(current.visit() + " -> ");
            List<GraphNode2> neighbourNodes = getNeighbours(current);
            for (GraphNode2 node : neighbourNodes) {
                if (!node.isVisited()) {
                    nodeStack.push(node);
                    node.visit();
                }
            }
        }
        System.out.println("END");
    }

    public void doTopologicalSort() {
        Stack<GraphNode2> nodeStack = new Stack<>();
        for (GraphNode2 node : nodeList) {
            recursiveTopologicalSort(node, nodeStack);
        }

        while(!nodeStack.isEmpty()) {
            System.out.print(nodeStack.pop().getNodeName() + " -> ");
        }
        System.out.print("END");
    }

    private void recursiveTopologicalSort(GraphNode2 currentNode, Stack nodeStack) {
        if (currentNode.isVisited()) return;
        List<GraphNode2> neighbours = getNeighbours(currentNode);
        //If no neighbours
        for (GraphNode2 neighbour : neighbours) {
            if (!neighbour.isVisited()) {
                recursiveTopologicalSort(neighbour, nodeStack);
            }
        }

        nodeStack.push(currentNode);
        currentNode.visit();
    }


}

class GraphNode2 {
    private int index;
    private String nodeName;
    private boolean isVisited;

    public GraphNode2(String nodeName, int index) {
        this.nodeName = nodeName;
        this.index = index;
    }

    public String visit() {
        this.isVisited = true;
        return this.nodeName;
    }

    public boolean isVisited() {
        return this.isVisited;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public int getIndex() {
        return this.index;
    }

}

class TestMyUndirectedGraph {
    public static void main(String[] args) {

        //  A0 ------- B1
        //  |          |  \
        //  C2 ------- D3     G6
        //  |          |  /
        //  E4 ------- F5
        //



        List<GraphNode2> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode2("A", 0));
        nodeList.add(new GraphNode2("B", 1));
        nodeList.add(new GraphNode2("C", 2));
        nodeList.add(new GraphNode2("D", 3));
        nodeList.add(new GraphNode2("E", 4));
        nodeList.add(new GraphNode2("F", 5));
        nodeList.add(new GraphNode2("G", 6));

        MyGraph2 myTestGraph = new MyGraph2(nodeList, MyGraph2.GraphRepresentationType.ADJACENCY_MATRIX);
        myTestGraph.addUndirectedEdge(0,new int[]{1,2});
        //myTestGraph.addUndirectedEdge(0,2);
        myTestGraph.addUndirectedEdge(1,new int[]{3,6});
        //myTestGraph.addUndirectedEdge(1,6);
        myTestGraph.addUndirectedEdge(2,new int[]{3,4});
        //myTestGraph.addUndirectedEdge(2,4);
        myTestGraph.addUndirectedEdge(3,new int[]{5});
        myTestGraph.addUndirectedEdge(4,new int[]{5});
        myTestGraph.addUndirectedEdge(5,new int[]{6});
        myTestGraph.displayGraph();

        System.out.println("------- BFS -------");
        //myTestGraph.bfs();
        System.out.println("------- DFS -------");
        myTestGraph.dfs();


        //  A0 ------- B1
        //  |          |  \
        //  C2 ------- D3     G6
        //  |          |  /
        //  E4 ------- F5
        //


        MyGraph2 testAdjListGraph = new MyGraph2(nodeList, MyGraph2.GraphRepresentationType.ADJACENCY_LIST);
        testAdjListGraph.addUndirectedEdge(0,new int[]{1,2});
        //myTestGraph.addUndirectedEdge(0,2);
        testAdjListGraph.addUndirectedEdge(1,new int[]{3,6});
        //myTestGraph.addUndirectedEdge(1,6);
        testAdjListGraph.addUndirectedEdge(2,new int[]{3,4});
        //myTestGraph.addUndirectedEdge(2,4);
        testAdjListGraph.addUndirectedEdge(3,new int[]{5});
        testAdjListGraph.addUndirectedEdge(4,new int[]{5});
        testAdjListGraph.addUndirectedEdge(5,new int[]{6});
        System.out.println();
        testAdjListGraph.displayGraph();



    }

}

class TestMyDirectedGraph{
    public static void main(String[] args) {
        // Dependant Graph
        //    A    B
        //    |   /  \
        //    `C `    `D
        //     |       /
        //    `E      /
        //    /  \   /
        //   `H   `F` ----> G
        //  ` -> represents dest node
        //   H Depends on E, E depends on C, C depends on A and B
        //   G Depends on F, F Depends on E and D, D depends on B

        List<GraphNode2> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode2("A", 0));
        nodeList.add(new GraphNode2("B", 1));
        nodeList.add(new GraphNode2("C", 2));
        nodeList.add(new GraphNode2("D", 3));
        nodeList.add(new GraphNode2("E", 4));
        nodeList.add(new GraphNode2("F", 5));
        nodeList.add(new GraphNode2("G", 6));
        nodeList.add(new GraphNode2("H", 7));

        MyGraph2 myDirectedGraph = new MyGraph2(nodeList, MyGraph2.GraphRepresentationType.ADJACENCY_MATRIX);
        myDirectedGraph.addDirectedEdge(0, new int[]{2});
        myDirectedGraph.addDirectedEdge(1, new int[]{2,3});
       // myDirectedGraph.addDirectedEdge(1, 3);
        myDirectedGraph.addDirectedEdge(2, new int[]{4});
        myDirectedGraph.addDirectedEdge(3, new int[]{5});
        myDirectedGraph.addDirectedEdge(4, new int[]{5,7});
        //myDirectedGraph.addDirectedEdge(4, 7);
        myDirectedGraph.addDirectedEdge(5, new int[]{6});
        myDirectedGraph.displayGraph();
        System.out.println("Topological Sort");
        myDirectedGraph.doTopologicalSort();


    }
}

