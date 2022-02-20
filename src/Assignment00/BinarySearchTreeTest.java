package Assignment00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void generalTest(){
        Tree<Integer> tree = new BinarySearchTree();
        tree.insert(-10);
        tree.insert(8);
        tree.insert(15);
        System.out.println(BinarySearchTreeAlgorithms.inOrderTraversal((BinarySearchTree) tree).toString());
    }

}