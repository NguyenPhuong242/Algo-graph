import java.util.*;

public class Graph {
    private int numVertices;
    private double density;
    private List<List<Integer>> adjacencyList;

    public Graph(int n, double theta) {
        numVertices = n;
        density = theta;
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        generateEdges();
    }

    private void generateEdges() {
        int numEdges = (int) (numVertices * (numVertices - 1) * density);
        Random rand = new Random();
        while (numEdges > 0) {
            int u = rand.nextInt(numVertices);
            int v = rand.nextInt(numVertices);
            if (u != v && !adjacencyList.get(u).contains(v)) {
                adjacencyList.get(u).add(v);
                numEdges--;
            }
        }
    }

    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

}
