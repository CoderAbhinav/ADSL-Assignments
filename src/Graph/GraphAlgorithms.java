package Graph;

import java.util.Arrays;


public class GraphAlgorithms {

    static class MinimumSpanningTree{
        int parent[];
        int key[];
        int cost;

        public MinimumSpanningTree(int V) {
            this.parent = new int[V];
            this.key = new int[V];
            this.cost = 0;
            Arrays.fill(key, Integer.MAX_VALUE);
        }

        @Override
        public String toString() {
            return "MinimumSpanningTree{" +
                    "parent=" + Arrays.toString(parent) +
                    ", key=" + Arrays.toString(key) +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static MinimumSpanningTree MinimumSpanningTreeAlgorithm(Graph g){
        int V = g.vertexCount();

        MinimumSpanningTree mst = new MinimumSpanningTree(V);
        mst.key[0] = 0;
        mst.parent[0] = -1;
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);

        for (int count = 0; count < V; count++){
            int u = -1;
            // find minimum
            for(int v = 0; v < V; v++){
                if ((u == -1 || mst.key[v] < mst.key[u]) && !vis[v]){
                    u = v;
                }
            }

            mst.cost += mst.key[u];
            vis[u] = true;

            // update keys of adjacent
            for (int v = 0; v < V; v++){
                if (g.edgeBetween(u, v)){
                    if (!vis[v] && mst.key[v] > g.get(u, v)){
                        mst.parent[v] = u;
                        mst.key[v] = g.get(u, v);
                    }
                }
            }

        }

        return mst;
    }
}
