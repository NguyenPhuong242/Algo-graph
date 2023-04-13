import java.util.*;

public class Dijkstra {
    private static final int INFINITY = Integer.MAX_VALUE;
    private int[] dist;
    private int[] prev;
    private boolean[] visited;
    private int[][] graph;
    private int numVertices;

    public Dijkstra(int[][] graph) {
        numVertices = graph.length;
        this.graph = graph;
    }

    public void shortestPath(int start) {
        dist = new int[numVertices];
        prev = new int[numVertices];
        visited = new boolean[numVertices];

        Arrays.fill(dist, INFINITY);
        Arrays.fill(prev, -1);

        dist[start] = 0;

        for (int i = 0; i < numVertices; i++) {
            int u = extractMin();
            visited[u] = true;
            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] != 0 && !visited[v] && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }
    }

    private int extractMin() {
        int minDist = INFINITY;
        int minVertex = -1;

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                minVertex = i;
            }
        }

        return minVertex;
    }
}
