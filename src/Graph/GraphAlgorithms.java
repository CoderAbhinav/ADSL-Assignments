package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class GraphAlgorithms {

    public static class Edge implements Comparable<Edge>{
        Integer weight;
        Integer u;
        Integer v;

        public Edge(Integer u, Integer v) {
            this.weight = 1;
            this.u = u;
            this.v = v;
        }

        public Edge(Integer u, Integer v, Integer weight) {
            this.weight = weight;
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", u=" + u +
                    ", v=" + v +
                    '}';
        }
    }

    static class MinimumSpanningTree{
        private int cost;
        protected ArrayList<Edge> edges;

        public MinimumSpanningTree() {
            this.edges = new ArrayList<>();
        }

        public int getCost() {
            return cost;
        }

        protected MinimumSpanningTree(int key[], int parent[], int cost){
            this.cost = cost;
            edges = new ArrayList<>();
            for(int i = 0; i < key.length; i++){
                edges.add(new Edge(parent[i], i, key[i]));

            }
        }

        protected void addEdge(Integer u, Integer v){
            // TODO: Implement a check for already existing edges
            edges.add(new Edge(u, v));
        }

        protected void addEdge(Integer u, Integer v, Integer weight){
            // TODO: Implement a check for already existing edges
            edges.add(new Edge(u, v, weight));
        }

        protected void addEdge(Edge edge){
            edges.add(edge);
        }
        @Override
        public String toString() {
            return "MinimumSpanningTree{" +
                    "cost=" + cost +
                    ", edges=" + edges +
                    '}';
        }
    }

    public static MinimumSpanningTree PrimsAlgorithm(Graph g){
        int V = g.vertexCount();
        int key[] = new int[V];
        int parent[] = new int[V];
        int cost = 0;
        Arrays.fill(key, Integer.MAX_VALUE);


        key[0] = 0; // store the weight to this edge
        parent[0] = -1; // store parent of current node
        boolean vis[] = new boolean[V]; // to mark visited
        Arrays.fill(vis, false);

        for (int count = 0; count < V; count++){
            int u = -1;
            // find minimum
            for(int v = 0; v < V; v++){
                if ((u == -1 || key[v] < key[u]) && !vis[v]){
                    u = v;
                }
            }
            // update variables
            cost += key[u];
            vis[u] = true;

            // update keys of adjacent
            for (int v = 0; v < V; v++){
                if (g.edgeBetween(u, v)){
                    if (!vis[v] && key[v] > g.get(u, v)){
                        parent[v] = u;
                        key[v] = g.get(u, v);
                    }
                }
            }
        }

        MinimumSpanningTree mst = new MinimumSpanningTree(key, parent, cost);
        return mst;
    }




    public static MinimumSpanningTree KrushkalsAlgorithm(Graph g){
        int n = g.vertexCount();
        int cost = 0;
        MinimumSpanningTree mst = new MinimumSpanningTree();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(Edge::compareTo);

        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (g.edgeBetween(i, j)){
                    priorityQueue.add(new Edge(i, j, g.get(i, j)));
                }
            }
        }

        boolean vis[] = new boolean[n];

        while (!priorityQueue.isEmpty()){
            Edge top = priorityQueue.poll();
            if (!vis[top.u] || !vis[top.v]){
                vis[top.u] = true;
                vis[top.v] = true;
                cost += top.weight;
                mst.addEdge(top);
            }
        }
        mst.cost = cost;
        return mst;
    }

}
