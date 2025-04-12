package com.kimlngo.leetcode.graph;

public class GraphByMapExercise {

    public static void main(String[] args) {
        /*GraphByMap graph = new GraphByMap();

        graph.addVertex("Tokyo");
        graph.addVertex("Dallas");
        graph.addVertex("Aspen");
        graph.addVertex("Hong Kong");
        graph.addVertex("Los Angeles");

        graph.addEdge("Tokyo", "Dallas");
        graph.addEdge("Tokyo", "Hong Kong");
        graph.addEdge("Dallas", "Aspen");
        graph.addEdge("Dallas", "Hong Kong");
        graph.addEdge("Dallas", "Los Angeles");

        graph.addEdge("Hong Kong", "Los Angeles");

        System.out.println(graph);

        System.out.println("===================");
        graph.removeVertex("Hong Kong");
        System.out.println(graph);*/

        dfsTraversal();
    }

    private static void dfsTraversal() {
        GraphByMap g = new GraphByMap();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "E");
        g.addEdge("D", "E");
        g.addEdge("D", "F");
        g.addEdge("E", "F");

        System.out.println(g.depthFirstTraversal("A"));

        System.out.println(g.breathFirstTraversal("A"));
    }
}
