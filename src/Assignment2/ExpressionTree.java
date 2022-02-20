package Assignment2;

import java.util.Stack;

public class ExpressionTree {
    TreeNode<Character> root;
    ExpressionTree(){
        root = null;
    }

    private boolean isOperator(char ch){
        if(ch=='+' || ch=='-'|| ch=='*' || ch=='/' || ch=='^'){
            return true;
        }
        return false;
    }

    public void BuildTree(String postfixExpression){
        Stack<TreeNode<Character>> stack = new Stack<>();

        TreeNode<Character> t1, t2, temp;

        for (int i = 0; i < postfixExpression.length(); i++){
            if ( !isOperator(postfixExpression.charAt(i))){
                temp = new TreeNode<Character>(postfixExpression.charAt(i));
                stack.push(temp);
            }else{
                temp = new TreeNode(postfixExpression.charAt(i));

                t1 = stack.pop();
                t2 = stack.pop();

                temp.left = t2;
                temp.right = t1;

                stack.push(temp);
            }
        }
        this.root = stack.pop();
    }

    private void inOrder(TreeNode<Character> node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void inOrder(){
        inOrder(this.root);
    }

}
