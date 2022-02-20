package Assignment00;

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
    protected TreeNode<Integer> root;

    BinarySearchTree(){
        root = null;
    }

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

    @Override
    public void delete(Integer key) {
        root = delete(root, key);
    }

    @Override
    public boolean contains(Integer key) {
        TreeNode<Integer> temp = this.root;
        while (temp != null){
            if(temp.data == key) return true;
            else if(temp.data < key){
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        return false;
    }
}
