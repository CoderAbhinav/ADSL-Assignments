package Graph;

public interface Graph {
    void put(int u, int v);
    void put(int u, int v, int weight);
    int remove(int u, int v);
    int get(int u, int v);
    boolean edgeBetween(int u, int v);
    int vertexCount();
}
