package javasrc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // map store first-level relationship(s1, <s2,value>)
        // DFS get path
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String u = equations[i][0], v = equations[i][1];
            if (!graph.containsKey(u)) {
                graph.put(u, new HashMap<>());
            }
            if (!graph.containsKey(v)) {
                graph.put(v, new HashMap<>());
            }
            graph.get(u).put(v, values[i]);
            graph.get(v).put(u, 1.0 / values[i]);
        }

        double[] result = new double[queries.length];
        int ri = 0;
        for (String[] query : queries) {
            String start = query[0], end = query[1];
            result[ri++] = calcEquationFrom(graph, start, end, new HashSet<>());
        }
        return result;

    }

    private double calcEquationFrom(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {

        if (!graph.containsKey(start) || visited.contains(start)) {
            return -1.0;
        }
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        visited.add(start);
        for (String neighbour : graph.get(start).keySet()) {
            double val = calcEquationFrom(graph, neighbour, end, visited);
            if (val == -1.0) {
                continue;
            }
            return val * graph.get(start).get(neighbour);
        }
        return -1.0;

    }
}
