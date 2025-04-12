package com.kimlngo.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public void addVertex(String id) {
        if (vertices.stream().noneMatch(v -> v.getId().equals(id))) {
            var newVertex = new Vertex(id);
            this.vertices.add(newVertex);
        }
    }

    public void addEdge(String v1, String v2) {
        try {
            var vertex1 = this.getVertexByStringId(v1);
            var vertex2 = this.getVertexByStringId(v2);

            vertex1.getNeighbors()
                    .add(vertex2);
            vertex2.getNeighbors()
                    .add(vertex1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeEdge(String v1, String v2) {
        try {
            var vertex1 = getVertexByStringId(v1);
            var vertex2 = getVertexByStringId(v2);

            vertex1.getNeighbors().remove(vertex2);
            vertex2.getNeighbors().remove(vertex1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeVertex(String id) {
        try {
            var removeVertex = getVertexByStringId(id);

            for (var v : vertices)
                v.getNeighbors().remove(removeVertex);

            vertices.remove(removeVertex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Vertex getVertexByStringId(String id) throws Exception {
        return vertices.stream()
                .filter(v -> v.getId()
                        .equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("ID " + id + " not found"));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var vertex : vertices) {
            sb.append("\t\"").append(vertex.getId()).append("\" - ");
            sb.append("\t").append(vertex.getNeighbors());
            sb.append("\n");
        }
        return "{\n" + sb + "}";
    }
}

