package Solutions;

import java.util.ArrayList;
import java.util.List;

interface Tree<T>{
    void insert(T data);
    void delete(T data);
    boolean find(T data);
}

class BinarySearchTree implements Tree<Integer>{
    protected TreeNode<Integer> root;

    public BinarySearchTree() {
        this.root = null;
    }

    private TreeNode<Integer> insert(TreeNode<Integer> node, Integer data){
        if (node == null){
            return new TreeNode<Integer>(data);
        } else if (node.data == data){
            return node;
        } else if (node.data < data){
            node.right = insert(node.right, data);
        } else {
            node.left = insert(node.left, data);
        }
        return node;
    }

    @Override
    public void insert(Integer data) {
        root = insert(root, data);
    }

    private TreeNode<Integer> delete(TreeNode<Integer> node, Integer data){
        if (node == null) return node;
        // finding the node
        else if (node.data > data) node.left = delete(node.left, data);
        else if (node.data < data) node.right = delete(node.right, data);
        else {
            // leaf node or node with single child
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            // internal node condition
            else {
                node.data = node.right.data;
                node.right = delete(node.right, node.data);
            }
        }
        return node;
    }

    @Override
    public void delete(Integer data) {
        root = delete(root, data);
    }

    @Override
    public boolean find(Integer data) {
        TreeNode<Integer> temp = root;
        while (temp != null){
            if (temp.data == data){
                return true;
            }else if (temp.data < data){
                temp = temp.right;
            }else {
                temp = temp.left;
            }
        }
        return false;
    }

    protected static class TreeNode<T>{
        protected T data;
        protected TreeNode<T> left, right;

        public TreeNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static class Algorithms{
        private static void inOrder(TreeNode<Integer> node, List<Integer> res){
            if (node == null) return;
            inOrder(node.left, res);
            res.add(node.data);
            inOrder(node.right, res);
        }

        public static List<Integer> inOrder(BinarySearchTree tree){
            List<Integer> res = new ArrayList<Integer>();
            inOrder(tree.root, res);
            return res;
        }
    }
}



public class BinarySearchTreeAssignment {
    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree();
        tree.insert(30);
        tree.insert(10);
        tree.insert(50);
        tree.insert(20);
        tree.insert(40);
        System.out.println((BinarySearchTree.Algorithms.inOrder((BinarySearchTree) tree).toString()));
        tree.delete(30);
        System.out.println((BinarySearchTree.Algorithms.inOrder((BinarySearchTree) tree).toString()));
        System.out.println(tree.find(10));
        System.out.println(tree.find(30));
    }
}
