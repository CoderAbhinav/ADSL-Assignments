package Assignment1;

public class BST_Recursive {
    private TreeNode<Integer> insert(TreeNode<Integer> node, Integer data){
        if (node == null){
            return new TreeNode<Integer>(data);
        }else if (data < node.data){
            node.left = insert(node.left, data);
        }else{
            node.right = insert(node.right, data);
        }
        return node;
    }

    private boolean find(TreeNode<Integer> node, Integer key){
        if(node == null) return false;
        else
        {
            if(node.data == key) return true;
            else if(key < node.data){
                return find(node.left, key);
            }else{
                return find(node.right, key);
            }
        }
    }


    private Integer minInTree(TreeNode<Integer> node){
        if (node.left == null) return node.data;

        return minInTree(node.left);
    }

    private Integer maxInTree(TreeNode<Integer> node){
        if (node.right == null) return node.data;

        return maxInTree(node.right);
    }
}
