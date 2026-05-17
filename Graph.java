/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * University of Westminster
 * Module: 5SENG003W Algorithms - Coursework (2025/26)
 * * Student Name: Dilni Rohansi Wijesinghe
 * Student ID (UOW): 21201103
 * Student ID (IIT): 20240771
 */

package graphcycledetector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    // Adjacency list: maps each vertex to its list of neighbours (outgoing edges)
    private Map<Integer, List<Integer>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    // Add a directed edge from 'from' to 'to'
    public void addEdge(int from, int to) {
        // Make sure both vertices exist in the map
        adj.putIfAbsent(from, new ArrayList<>());
        adj.putIfAbsent(to, new ArrayList<>());
        adj.get(from).add(to);
    }

    // Return all vertices in the graph
    public Set<Integer> getVertices() {
        return adj.keySet();
    }

    // Return the neighbours (outgoing edges) of a vertex
    public List<Integer> getNeighbours(int vertex) {
        return adj.getOrDefault(vertex, new ArrayList<>());
    }

    // Return the full adjacency list (used by CycleDetector)
    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adj;
    }

    // Remove a vertex and all edges pointing TO it (incoming edges)
    // This is required by the sink elimination algorithm
    public void removeVertex(int vertex) {
        // Remove the vertex's own entry
        adj.remove(vertex);
        // Remove any edges from other vertices that point to this vertex
        for (List<Integer> neighbours : adj.values()) {
            neighbours.remove(Integer.valueOf(vertex));
        }
    }

    // Print the graph (useful for debugging and Task 4 output)
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Return how many vertices are in the graph
    public int size() {
        return adj.size();
    }
}

