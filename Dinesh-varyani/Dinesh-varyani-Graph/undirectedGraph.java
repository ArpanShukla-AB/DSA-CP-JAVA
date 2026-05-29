public class undirectedGraph{
    private int V;
    private int E;
    private int[][] adjMatrix;

    public undirectedGraph(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u , int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        E++;
    }

    public static void main(String[] args) {
        undirectedGraph graph = new undirectedGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        // Print the adjacency matrix
        for (int i = 0; i < graph.V; i++) {
            for (int j = 0; j < graph.V; j++) {
                System.out.print(graph.adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}