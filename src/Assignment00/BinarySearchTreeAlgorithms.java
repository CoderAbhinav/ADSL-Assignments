package Assignment00;
import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTreeAlgorithms{
    private static void inOrderTraversal(TreeNode<Integer> node, ArrayList<Integer> result){
        if(node == null) return;
        inOrderTraversal(node.left, result);
        result.add(node.data);
        inOrderTraversal(node.right, result);
    }

    // implementation using stack
    public static ArrayList<Integer> inOrderTraversal(BinarySearchTree tree){
        if(tree.root == null){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode<Integer> curr = tree.root;

        while (curr != null || st.isEmpty() == false){
            while (curr != null){
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            result.add(curr.data);
            curr = curr.right;
        }

        return result;
    }

    private static void preOrderTraversal(TreeNode<Integer> node, ArrayList<Integer> result){
        if(node == null) return;
        result.add(node.data);
        inOrderTraversal(node.left, result);
        inOrderTraversal(node.right, result);
    }

    public static ArrayList<Integer> preOrderTraversal(BinarySearchTree tree){
        ArrayList<Integer> result = new ArrayList<>();
        inOrderTraversal(tree.root, result);
        return result;
    }

    private static void postOrderTraversal(TreeNode<Integer> node, ArrayList<Integer> result){
        if(node == null) return;
        inOrderTraversal(node.left, result);
        inOrderTraversal(node.right, result);
        result.add(node.data);
    }

    public static ArrayList<Integer> postOrderTraversal(BinarySearchTree tree){
        ArrayList<Integer> result = new ArrayList<>();
        inOrderTraversal(tree.root, result);
        return result;
    }

}
