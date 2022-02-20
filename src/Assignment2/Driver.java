package Assignment2;

public class Driver {
    public static void main(String[] args) {
        ExpressionTree expressionTree = new ExpressionTree();
        expressionTree.BuildTree("ABC*+D/");
        expressionTree.inOrder();
    }
}
