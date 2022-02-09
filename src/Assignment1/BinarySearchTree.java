package Assignment1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

class TreeNode<T>{
    protected T data;
    protected TreeNode<T> left;
    protected TreeNode<T> right;

    public TreeNode(){}
    public TreeNode(T data) {
        this.data = data;
    }
}

public class BinarySearchTree implements Tree<Integer>{
    private Logger logger;

    protected TreeNode<Integer> root;

    public BinarySearchTree() {
        root = null;
        logger = Logger.getLogger(BinarySearchTree.class.getName());
    }

    // iterative
    @Override
    public void insert(Integer data) {
        if(root == null){
            root = new TreeNode<Integer>(data);
            return;
        }
        TreeNode<Integer> temp = root;
        while(temp != null){
            if(temp.data == data){
                break;
            }
            else if(data < temp.data){
                if(temp.left == null) temp.left = new TreeNode<Integer>(data);
                else temp = temp.left;
            }else{
                if(temp.right == null) temp.right = new TreeNode<Integer>(data);
                else temp = temp.right;
            }
        }
    }

    private TreeNode delete(TreeNode<Integer> node, Integer key){
        if(node == null) return node;
        // found the key
        else if(node.data == key){
            // if it's a leaf node
            if(node.left == null && node.right == null) return null;
            // if it has right child or two child
            else if(node.right != null){
                node.data = node.right.data;
                node.right = delete(node.right, node.right.data);
            }
            // if tree has only left node
            else if(node.left != null){
                node.data = node.left.data;
                node.left = delete(node.left, node.left.data);
            }
        }else if(node.data < key){
            node.right = delete(node.right, key);
        }else{
            node.left = delete(node.left, key);
        }
        return node;
    }

    // recursive
    @Override
    public void delete(Integer data) {
        root = delete(root, data);
    }

    private void inOrderTraversal(TreeNode<Integer> node, ArrayList<Integer> result){
        if(node == null) return;
        inOrderTraversal(node.left, result);
        result.add(node.data);
        inOrderTraversal(node.right, result);
    }

    // recursive
    @Override
    public List<Integer> inOrderTraversal() {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderTraversal(this.root, result);
        return result;
    }

    private void preOrderTraversal(TreeNode<Integer> node, ArrayList<Integer> result){
        if(node == null) return;
        result.add(node.data);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }

    // recursive
    @Override
    public List<Integer> preOrderTraversal() {
        ArrayList<Integer> result = new ArrayList<>();
        preOrderTraversal(this.root, result);
        return result;
    }

    private void postOrderTraversal(TreeNode<Integer> node, ArrayList<Integer> result){
        if(node == null) return;
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
        result.add(node.data);
    }

    // recursive
    @Override
    public List<Integer> postOrderTraversal() {
        ArrayList<Integer> result = new ArrayList<>();
        postOrderTraversal(this.root, result);
        return result;
    }

    // BFS
    @Override
    public List<List<Integer>> levelOrderTraversal() {

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) return result;

        ArrayList<Integer> levelData = new ArrayList<Integer>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (queue.isEmpty() == false){
            TreeNode<Integer> curr = queue.poll();
            if(curr == null){
                result.add(levelData);
                levelData = new ArrayList<Integer>();
                if(queue.isEmpty()) break;
                queue.add(null);
            }else{
                levelData.add(curr.data);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return result;
    }

    // iterative
    @Override
    public boolean find(Integer data) {
        TreeNode<Integer> temp = this.root;
        while (temp != null){
            if(temp.data == data) return true;
            else if(temp.data < data){
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        return false;
    }

    // iterative
    @Override
    public Integer minInTree() {
        TreeNode<Integer> temp = this.root;
        Integer result = -1;

        while (temp != null){
            result = temp.data;
            temp = temp.left;
        }
        return result;
    }

    // iterative
    @Override
    public Integer maxInTree() {
        TreeNode<Integer> temp = this.root;
        Integer result = -1;

        while (temp != null){
            result = temp.data;
            temp = temp.right;
        }
        return result;
    }
}