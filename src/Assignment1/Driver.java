package Assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    static Scanner sc = new Scanner(System.in);

    private static int Options(){
        System.out.println("\nSelect : ");
        System.out.println("1. INSERT ELEMENT IN BST");
        System.out.println("2. DELETE ELEMENT in BST");
        System.out.println("3. SEARCH ELEMENT");
        System.out.println("4. IN-ORDER TRAVERSAL");
        System.out.println("5. PRE-ORDER TRAVERSAL");
        System.out.println("6. POST-ORDER TRAVERSAL");
        System.out.println("7. LEVEL-ORDER TRAVERSAL");
        System.out.println("8. PRINT MAX");
        System.out.println("9. PRINT MIN");
        System.out.print("0. EXIT\n> ");
        return Integer.parseInt(sc.nextLine());
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree();

        while (true){
            int sel = Options();
            if (sel == 1){
                System.out.print("Enter the Number to be added\n> ");
                tree.insert(Integer.parseInt(sc.nextLine()));
            }else if (sel == 2){
                System.out.print("Enter the Number to be deleted\n> ");
                tree.delete(Integer.parseInt(sc.nextLine()));
            }else if (sel == 3){
                System.out.print("Enter the number to search\n> ");
                boolean res = tree.find(Integer.parseInt(sc.nextLine()));
                if (res == true){
                    System.out.println("Element Found");
                }else{
                    System.out.println("Element Not Found");
                }

            }else if (sel == 4){
                System.out.println("Here is the inorder traversal");
                for(int i: tree.inOrderTraversal()){
                    System.out.print(i + " ");
                }
            }else if(sel == 5){
                System.out.println("Here is the preorder traversal");
                for(int i: tree.preOrderTraversal()){
                    System.out.print(i + " ");
                }
            }else if(sel == 6){
                System.out.println("Here is the postorder traversal");
                for(int i: tree.postOrderTraversal()){
                    System.out.print(i + " ");
                }
            }else if (sel == 7){
                System.out.println("Here is Level Order Traversal");
                int k = 0;
                for (List<Integer> i: tree.levelOrderTraversal()){
                    System.out.print("LEVEL " + k + " => ");
                    for (int j: i){
                        System.out.print(j + " ");
                    }
                    System.out.println(" ");
                    k++;
                }
            }else if (sel == 8){
                int max_val = tree.maxInTree();
                if (max_val  == -1){
                    System.out.println("Tree is Empty");
                }else{
                    System.out.println("Maximum in tree is : " + max_val);
                }
            }else if (sel == 9){
                int min_val = tree.minInTree();
                if (min_val  == -1){
                    System.out.println("Tree is Empty");
                }else{
                    System.out.println("Minimum in tree is : " + min_val);
                }
            }
            else if (sel == 0){
                System.out.println("BYE!");
                break;
            }

        }
        sc.close();
    }
}
