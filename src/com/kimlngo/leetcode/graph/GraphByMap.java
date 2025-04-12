package com.kimlngo.leetcode.graph;

import java.util.*;

public class GraphByMap {

    private final Map<String, List<String>> adjacencyMap;

    public GraphByMap() {
        this.adjacencyMap = new HashMap<>();
    }

    public void addVertex(String id) {
        this.adjacencyMap.computeIfAbsent(id, k -> new ArrayList<>());
    }

    public void addEdge(String v1, String v2) {
        this.adjacencyMap.get(v1)
                .add(v2);
        this.adjacencyMap.get(v2)
                .add(v1);
    }

    public void removeEdge(String v1, String v2) {
        this.adjacencyMap.get(v1)
                .remove(v2);
        this.adjacencyMap.get(v2)
                .remove(v1);
    }

    public void removeVertex(String removeVertex) {
        for (var entry : this.adjacencyMap.entrySet()) {
            entry.getValue()
                    .remove(removeVertex);
        }

        this.adjacencyMap.remove(removeVertex);
    }

    public List<String> depthFirstTraversal(String startId) {
        List<String> traverseResult = new ArrayList<>();
        dfsTraverse(startId, traverseResult);

        return traverseResult;
    }

    private void dfsTraverse(String id, List<String> traverseList) {
        if(traverseList.contains(id)) return;

        traverseList.add(id);
        for(var neighbor : this.adjacencyMap.get(id)) {
            dfsTraverse(neighbor, traverseList);
        }
    }

    public List<String> breathFirstTraversal(String startId) {
        List<String> visited = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.add(startId);

        while (!queue.isEmpty()) {
            var id = queue.remove();

            if(!visited.contains(id)) visited.add(id);

            for (var neighbor : this.adjacencyMap.get(id)) {
                if(!visited.contains(neighbor) && !queue.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        return visited;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (var entry : this.adjacencyMap.entrySet()) {
            sb.append("\t\"")
                    .append(entry.getKey())
                    .append("\"\t\t - ");
            sb.append("\t")
                    .append(entry.getValue());
            sb.append("\n");
        }

        return "{\n" + sb + "}";
    }
}
