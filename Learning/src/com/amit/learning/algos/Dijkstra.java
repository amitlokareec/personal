package com.amit.learning.algos;

import java.util.*;

class Dijkstra {
    static class Edge {
        int node, distance;
        Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int n = 4; // A, B, C, D = 0,1,2,3
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // Mind here Node A, B,C, D are 0,1,2,3 and A(0)-B(1): 2, A(0)-C(2): 1, B(1)-D(3): 3, C(2)-D(3): 4
        /*
          A---2----B
          *        *
          1        3
          *        *
          C---4----D
         */
        graph[0].add(new Edge(1, 2));
        graph[0].add(new Edge(2, 1));
        graph[1].add(new Edge(3, 3));
        graph[2].add(new Edge(3, 4));
        dijkstra(graph, 0); // source = A (index 0)
        /*
         * Objective
         * We want shortest path from A to all other nodes.
         * A-B: 2
         * A-C: 1
         * B-D: 3
         * C-D: 4
         */
    }

    /*
     * We use int[] of List here instead of List of List because it’s:
     * Simple and fast
     * Works well with PriorityQueue + custom comparator (Comparator.comparingInt(a -> a[1]))
     * Lightweight (no extra object creation or boxing/unboxing like with List<Integer>)
     *
     *  Why use int[] instead of List<Integer>
     *        int[]                        List<Integer>
     * Primitive type → fast               Uses boxed Integer → slower
     * Fixed size, lightweight             Extra overhead for List object
     * Easy to compare by index            Harder to write comparators
     */
    private static void dijkstra(List<Edge>[] graph, int startingPoint) {
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startingPoint] = 0; // Starting at 0,0
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{startingPoint, 0}); // starting at 0,0
        while (!pq.isEmpty()) {
            int[] edgeArr = pq.poll();
            System.out.println("Running for:" +pq.size());
            int distanceTraveled = edgeArr[1];
            if (distanceTraveled > distance[edgeArr[0]]) continue;
            int nodeVisited = edgeArr[0];
            for (Edge edge : graph[nodeVisited]) {
                int nextNode = edge.node;
                int distanceToNextNode = edge.distance;
                if (distance[nextNode] > distance[nodeVisited] + distanceToNextNode) {
                    distance[nextNode] = distance[nodeVisited] + distanceToNextNode;
                    pq.offer(new int[]{nextNode, distance[nextNode]});
                }
            }
        }
        for (int j = 0; j < distance.length; j++) {
            System.out.println("Shortest distance to " + (char)('A' + j) + ": " + distance[j]);
        }
    }
}
