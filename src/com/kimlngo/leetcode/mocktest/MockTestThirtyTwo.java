package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.Util;

import java.util.*;
import java.util.stream.IntStream;

public class MockTestThirtyTwo {
    public static void main(String[] args) {
        var sol = new MockTestThirtyTwo();
//        System.out.println(sol.checkRecord("APLPLPLPLLLP"));

        System.out.println(sol.networkDelayTime(
                Util.readInput2DArray("[[1,2,1],[2,1,3]]"), 2, 2));
    }

    public boolean checkRecord(String s) {
        int absentCount = 0;
        List<Integer> lateIndex = new ArrayList<>();

        char attd;
        for (int i = 0; i < s.length(); i++) {
            attd = s.charAt(i);

            if (attd == 'A')
                absentCount++;
            else if (attd == 'L')
                lateIndex.add(i);

            if (absentCount >= 2) return false;
            if (lateIndex.size() >= 3) {
                //check if 3 consecutive index occurred.
                int day1 = lateIndex.get(lateIndex.size() - 3);
                int day2 = lateIndex.get(lateIndex.size() - 2);
                int day3 = lateIndex.getLast();

                return !(day2 - day1 == 1 && day3 - day2 == 1);
            }
        }
        return true;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        //1)convert times[][] to List<Weight>
        Graph graph = buildDirectedGraph(n, times);

        //2)create a Set<Integer> of visited nodes
        Set<Vertex> visited = new HashSet<>();

        //3)declare min weight count
        int time = bfsGraph(graph, graph.getVertex(k), visited);
        if (visited.size() < n) return -1;
        else return time;
    }

    private int bfsGraph(Graph graph, Vertex start, Set<Vertex> visited) {
        Queue<Vertex> q = new ArrayDeque<>();
        q.add(start);
        int time = 0;

        while (!q.isEmpty()) {
            int qsize = q.size();

            for (int i = 0; i < qsize; i++) {
                Vertex v = q.poll();
                visited.add(v);
                var unvisitedNeighbors = v.getNeighbors()
                                          .stream()
                                          .filter(n -> !visited.contains(n))
                                          .toList();
                q.addAll(unvisitedNeighbors);
                time += timeTravel(graph, v, unvisitedNeighbors);
            }
        }

        return time;
    }

    private int timeTravel(Graph g, Vertex start, List<Vertex> neighbors) {
        return neighbors.stream()
                        .mapToInt(end -> g.getWeight(start, end))
                        .max()
                        .orElse(0);
    }

    private Graph buildDirectedGraph(int n, int[][] times) {
        return new Graph(n, times);
    }
}


class Graph {
    private static final String KEY = "%d-%d";
    List<Vertex> vertices;
    Map<String, Integer> weight;

    public Graph(int n, int[][] times) {
        this.vertices = new ArrayList<>();
        this.weight = new HashMap<>();

        IntStream.range(1, n + 1)
                 .forEach(i -> this.vertices.add(new Vertex(i)));

        Arrays.stream(times)
              .forEach(t -> {
                  String key = String.format(KEY, t[0], t[1]);
                  weight.put(key, t[2]);

                  var start = getVertex(t[0]);
                  var end = getVertex(t[1]);

                  if (start != null && end != null)
                      start.addNeighbor(end);
              });
    }

    public int getWeight(Vertex start, Vertex end) {
        return this.weight.get(String.format(KEY, start.getVal(), end.getVal()));
    }

    public Vertex getVertex(Integer id) {
        return this.vertices.stream()
                            .filter(v -> v.getVal()
                                          .equals(id))
                            .findFirst()
                            .orElse(null);
    }
}

class Vertex {
    Integer val;
    List<Vertex> neighbors;

    public Vertex(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Integer getVal() {
        return this.val;
    }

    public List<Vertex> getNeighbors() {
        return this.neighbors;
    }

    public void addNeighbor(Vertex neighbor) {
        this.neighbors.add(neighbor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(val, vertex.val);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "val=" + val +
                '}';
    }
}