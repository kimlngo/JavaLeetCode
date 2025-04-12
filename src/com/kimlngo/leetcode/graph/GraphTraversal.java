package com.kimlngo.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {
    public static void main(String[] args) throws Exception {
        Graph g = new Graph();
        ;

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

        System.out.println(g);

        var sut = new GraphTraversal();
        System.out.println("Depth First Traversal");
        System.out.println(
                sut.depthFirstTraversal(g.getVertexByStringId("A")));

        System.out.println("Breath First Traversal");
        System.out.println(
                sut.breathFirstTraversal(g.getVertexByStringId("A")));
    }

    private List<Vertex> depthFirstTraversal(Vertex vertex) {
        List<Vertex> traverse = new ArrayList<>();
        traverseDFS(vertex, traverse);
        return traverse;
    }

    private void traverseDFS(Vertex vertex, List<Vertex> traverseList) {
        if (traverseList.contains(vertex))
            return;

        traverseList.add(vertex);
        for (var v : vertex.getNeighbors()) {
            traverseDFS(v, traverseList);
        }
    }

    private List<Vertex> breathFirstTraversal(Vertex vertex) {
        List<Vertex> bfsTraverse = new ArrayList<>();

        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            var v = queue.remove();

            if (!bfsTraverse.contains(v)) {
                bfsTraverse.add(v);
            }

            queue.addAll(v.getNeighbors()
                    .stream()
                    .filter(n -> !bfsTraverse.contains(n) && !queue.contains(n))
                    .toList());
        }

        return bfsTraverse;
    }
}
