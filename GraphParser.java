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

/* Task 4 & 5*/



package graphcycledetector;

import java.util.*;

public class CycleDetector {

    // -----------------------------------------------------------------------
    // Task 4: Sink Elimination Algorithm
    // -----------------------------------------------------------------------
    public static boolean isAcyclic(Graph g) {
        // Work on a copy so we don't destroy the original graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> e : g.getAdjacencyList().entrySet())
            graph.put(e.getKey(), new ArrayList<>(e.getValue()));

        while (!graph.isEmpty()) {
            Integer sink = null;
            for (int v : graph.keySet()) {
                if (graph.get(v).isEmpty()) {
                    sink = v;
                    break;
                }
            }

            if (sink == null) {
                System.out.println("\n[!] ALGORITHM STUCK: No more sinks found.");
                System.out.println("Remaining vertices forming cycle(s): " + graph.keySet());
                return false; // Result: No (Graph is CYCLIC)
            }

            System.out.println("Removing sink: " + sink);

            graph.remove(sink);
            for (List<Integer> list : graph.values())
                list.remove(sink);
        }

        System.out.println("All vertices removed — graph is acyclic.");
        return true;
    }

    // -----------------------------------------------------------------------
    // Task 5: Find and PRINT the actual cycle path using DFS
    // -----------------------------------------------------------------------
    public static boolean detectCycleDFS(Graph g) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> stack   = new HashSet<>();
        List<Integer> path   = new ArrayList<>();

        for (int v : g.getVertices()) {
            if (!visited.contains(v)) {
                List<Integer> cycle = dfs(v, g, visited, stack, path);
                if (cycle != null) {
                    StringBuilder sb = new StringBuilder("Cycle found: ");
                    for (int i = 0; i < cycle.size(); i++) {
                        sb.append(cycle.get(i));
                        if (i < cycle.size() - 1) sb.append(" -> ");
                    }
                    System.out.println(sb.toString());
                    return true;
                }
            }
        }
        return false;
    }

    // Recursive DFS — returns the cycle list when found, or null
    private static List<Integer> dfs(int v, Graph g,
                                      Set<Integer> visited,
                                      Set<Integer> stack,
                                      List<Integer> path) {
        visited.add(v);
        stack.add(v);
        path.add(v);

        for (int neighbour : g.getNeighbours(v)) {
            if (!visited.contains(neighbour)) {
                List<Integer> cycle = dfs(neighbour, g, visited, stack, path);
                if (cycle != null) return cycle;
            } else if (stack.contains(neighbour)) {
                // Back-edge found — extract the cycle from path
                List<Integer> cycle = new ArrayList<>();
                int startIndex = path.indexOf(neighbour);
                cycle.addAll(path.subList(startIndex, path.size()));
                cycle.add(neighbour); // close the loop
                return cycle;
            }
        }

        // Backtrack
        stack.remove(v);
        path.remove(path.size() - 1);
        return null;
    }

    // Replace the current empty findCycle with this:
    public List<Integer> findCycle(Graph g) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> stack = new HashSet<>();
        List<Integer> path = new ArrayList<>();

        for (int v : g.getVertices()) {
            if (!visited.contains(v)) {
                List<Integer> cycle = dfs(v, g, visited, stack, path);
                if (cycle != null) return cycle;
            }
        }
        return null; // No cycle found
    }
}
