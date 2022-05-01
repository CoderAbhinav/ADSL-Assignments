package Solutions;

import Graph.Graph;

import java.util.Arrays;

class GraphLib{
    public interface Graph {
        void put(int u, int v);
        void put(int u, int v, int weight);
        int remove(int u, int v);
        int get(int u, int v);
        boolean edgeBetween(int u, int v);
        int vertexCount();
    }

    public static class AdjecencyMatrix implements Graph {
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

    class GraphAlgorithms{
        public static class MinimumSpanningTree{
            public int cost;
            public Graph graph;

            public MinimumSpanningTree(int n) {
                this.cost = 0;
                this.graph = new AdjecencyMatrix(n);
            }

            @Override
            public String toString() {
                return "MinimumSpanningTree{" +
                        "cost=" + cost +
                        ", graph=" + graph +
                        '}';
            }
        }

        public static MinimumSpanningTree buildMinimumSpanningTree(Graph graph){
            int vertexCount = graph.vertexCount();
            MinimumSpanningTree res = new MinimumSpanningTree(vertexCount);
            int[] key = new int[vertexCount];
            int[] parent = new int[vertexCount];
            boolean[] vis = new boolean[vertexCount];

            Arrays.fill(key, Integer.MAX_VALUE);
            Arrays.fill(vis, false);
            key[0] = 0; parent[0] = -1;

            for (int i = 0; i < vertexCount; i++){
                    int u = -1;
                    // finding the minimum adjacent edge
                    for (int v = 0; v < vertexCount; v++){
                        if (((u == -1) || key[v] < key[u]) && !vis[v]){
                            u = v;
                        }
                    }

                    res.cost += key[u];
                    vis[u] = true;

                    // update the adjacent vertex accordingly
                    for (int v = 0; v < vertexCount; v++){
                        if (graph.edgeBetween(u, v)){
                            if (!vis[v] && key[v] > graph.get(u, v)){
                                parent[v] = u;
                                key[v] = graph.get(u, v);
                            }
                        }
                    }
            }



            return res;
        }

    }
}





public class GraphAssignments {
    public static void main(String[] args) {
        GraphLib.Graph g = new GraphLib.AdjecencyMatrix(3);
        g.put(0, 1, 5);
        g.put(1, 2, 100);
        g.put(0, 2, 20);
        g.put(1, 3, 10);
        g.put(2, 3, 5);

        System.out.println(GraphLib.GraphAlgorithms.buildMinimumSpanningTree(g));

    }
}
