package Graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void put() {

        Graph g = new AdjecencyMatrix(3);
        g.put(0, 1, 5);
        g.put(1, 2, 100);
        g.put(0, 2, 20);
        g.put(1, 3, 10);
        g.put(2, 3, 5);

        assertEquals(GraphAlgorithms.PrimsAlgorithm(g).getCost(), GraphAlgorithms.KrushkalsAlgorithm(g).getCost());
    }
}