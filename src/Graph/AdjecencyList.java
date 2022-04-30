package Graph;

import java.util.List;

public class AdjecencyList implements Graph{
    protected List<List<Integer>> adj;

    @Override
    public void put(int u, int v) {

    }

    @Override
    public void put(int u, int v, int weight) {

    }

    @Override
    public int remove(int u, int v) {
        return 0;
    }

    @Override
    public int get(int u, int v) {
        return 0;
    }

    @Override
    public boolean edgeBetween(int u, int v) {
        return false;
    }

    @Override
    public int vertexCount() {
        return 0;
    }
}
