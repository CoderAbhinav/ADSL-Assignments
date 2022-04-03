package Graph;

import java.util.Arrays;

public class AdjecencyMatrix implements Graph{
    protected int adj[][];
    protected int n;
    protected boolean directed;
    private int default_val = Integer.MAX_VALUE;

    public AdjecencyMatrix(int n) {
        this.n = n;
        this.adj = new int[n + 1][n + 1];
        Arrays.stream(adj).forEach(a -> Arrays.fill(a, default_val));
        this.directed = false;
    }

    public AdjecencyMatrix(int n, boolean directed) {
        this.n = n;
        this.adj = new int[n + 1][n + 1];
        Arrays.stream(adj).forEach(a -> Arrays.fill(a, default_val));
        this.directed = directed;
    }

    @Override
    public void put(int u, int v) {
        assert 0 <= u && u <= n && 0 <= v && v <= n: "Invalid vertex";
        adj[u][v] = 1;
        if (!directed){
            adj[v][u] = 1;
        }
    }

    @Override
    public void put(int u, int v, int weight) {
        assert 0 <= u && u <= n && 0 <= v && v <= n: "Invalid vertex";
        adj[u][v] = weight;
        if (!directed){
            adj[v][u] = weight;
        }
    }

    @Override
    public int remove(int u, int v) {
        assert 0 <= u && u <= n && 0 <= v && v <= n: "Invalid vertex";
        int prev = adj[u][v];
        // removing edge
        adj[u][v] = default_val;
        if (!directed){
            adj[v][u] = default_val;
        }
        return prev;
    }

    @Override
    public int get(int u, int v) {
        assert 0 <= u && u <= n && 0 <= v && v <= n: "Invalid vertex";
        return adj[u][v];
    }

    @Override
    public boolean edgeBetween(int u, int v) {
        if (adj[u][v] == default_val){
            return false;
        }
        return true;
    }

    @Override
    public int vertexCount() {
        return n + 1;
    }

    @Override
    public String toString() {
        return "AdjecencyMatrix{" +
                "adj=\n" + Arrays.deepToString(adj) +
                "\n, n=" + n +
                ", directed=" + directed +
                ", default_val=" + default_val +
                '}';
    }
}
