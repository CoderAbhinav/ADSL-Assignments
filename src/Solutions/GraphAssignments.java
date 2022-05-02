package Solutions;
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

    static class GraphAlgorithms{
        static class MinimumSpanningTree{
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
                    if (((u == -1) || (key[v] < key[u])) && !vis[v]){
                        u = v;
                        System.out.println(u);
                    }
                }

                res.cost += key[u];
                vis[u] = true;

                // update the adjacent vertex accordingly
                for (int v = 0; v < vertexCount; v++){
                    if (graph.edgeBetween(u, v)){

                        if (!vis[v] && key[v] > graph.get(u, v)){
                            System.out.println("Updated " + v + " to " + graph.get(u, v));
                            parent[v] = u;
                            key[v] = graph.get(u, v);
                        }
                    }
                }
            }



            return res;
        }

        private static int minDistance(int[] dist, boolean sptSet[], int V){
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (sptSet[v] == false && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }

        private static void printSolution(int dist[], int V)
        {
            System.out.println("Vertex \t\t Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t\t " + dist[i]);
        }

        public static void DijakstrasAlgorithm(Graph graph, int src){
            int vertexCount = graph.vertexCount();
            int[] dist = new int[vertexCount];
            boolean[] sptSet = new boolean[vertexCount];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(sptSet, false);

            dist[src] = 0;

            for (int count = 0; count < vertexCount; count++){
                int u = minDistance(dist, sptSet, vertexCount);
                sptSet[u] = true;

                for (int v = 0; v < vertexCount; v++){
                    if (!sptSet[v] &&  graph.edgeBetween(u, v) &&  dist[u] != Integer.MAX_VALUE && (dist[u] + graph.get(u, v) < dist[v])){
                        dist[v] = dist[u] + graph.get(u, v);
                    }
                }

            }

            printSolution(dist, vertexCount);
        }

    }
}





public class GraphAssignments {
    public static void main(String[] args) {
        GraphLib.Graph g = new GraphLib.AdjecencyMatrix(3);
        g.put(0, 1, 10);
        g.put(0, 2, 100);
        g.put(1, 2, 30);
        g.put(2, 3, 10);
        g.put(1, 3, 500);

        System.out.println(g.toString());
//        System.out.println(GraphLib.GraphAlgorithms.buildMinimumSpanningTree(g));
        GraphLib.GraphAlgorithms.DijakstrasAlgorithm(g, 0);

    }
}
