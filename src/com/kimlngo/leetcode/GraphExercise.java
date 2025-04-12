package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.Graph;

public class GraphExercise {
    public static void main(String[] args) {
        Graph graph = new Graph();

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

        System.out.println("Removing Hong Kong vertex");
        graph.removeVertex("Hong Kong");
        System.out.println(graph);
    }
}
