package Assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Tree<Integer> tree = new BinarySearchTree();
    int[] nums =  {10, 5, 15, 1, 8, 12, 6, 9, 13};

    @Test
    void insert() {

        for(int i: nums){
            tree.insert(i);
        }

        for(int i: nums){
            assertEquals(true, tree.find(i));
        }

        assertEquals(false, tree.find(99));
    }

    @Test
    void delete() {
        insert();
        tree.delete(6);
        assertEquals(false, tree.find(6));
        tree.delete(5);
        assertEquals(false, tree.find(5));
    }

    @Test
    void inOrderTraversal() {

    }
}