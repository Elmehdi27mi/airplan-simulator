package com.example.volapp.dijikstra;

import java.util.*;

public class Djikstra {
    private int V ;
    public int getV() {
        return V;
    }
    public void setV(int v) {
        V = v;
    }
    public Djikstra(int v) {
        super();
        V = v;
    }

    private List<Boolean> shortestPathSet;

    private int minDistance(List<Double> distance, List<Boolean> shortestPathSet) {
        double min = Double.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!shortestPathSet.get(v) && distance.get(v) <= min) {
                min = distance.get(v);
                minIndex = v;
            }
        }
        return minIndex;
    }
    public List<Integer> dijkstra(List<List<Double>> graph, int src) {
        List<Double> distance = new ArrayList<>(Collections.nCopies(V, Double.MAX_VALUE));
        List<Integer> predecessors = new ArrayList<>(Arrays.asList(new Integer[V]));
        shortestPathSet = new ArrayList<>(Arrays.asList(new Boolean[V]));

        for (int i = 0; i < V; i++) {
            predecessors.set(i, -1);
            shortestPathSet.set(i, false);
            distance.set(i, Double.MAX_VALUE); // Ajout de cette lig
        }
        distance.set(src, 0.0);

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(distance, shortestPathSet);

            shortestPathSet.set(u, true);

            for (int v = 0; v < V; v++) {
                if (!shortestPathSet.get(v) && graph.get(u).get(v) != 0 && distance.get(u) != Double.MAX_VALUE &&
                        distance.get(u) + graph.get(u).get(v) < distance.get(v)) {
                    distance.set(v, distance.get(u) + graph.get(u).get(v));
                    predecessors.set(v, u);
                }
            }
        }

        return predecessors;
    }
    public List<String> getShortestPath(List<Integer> predecessors, int destination, Map<Integer, String> nodeNames) {
        List<String> pathNodes = new ArrayList<>();
        int current = destination;
        while (current != -1) {
            pathNodes.add(nodeNames.get(current));
            current = predecessors.get(current);
        }
        Collections.reverse(pathNodes);
        return pathNodes;
    }
}