package Assignment2;

public class TreeNode<T> {
    protected T data;
    protected TreeNode<T> left;
    protected TreeNode<T> right;

    public TreeNode(){}
    public TreeNode(T data) {
        this.data = data;
    }
}
