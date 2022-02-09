package Assignment1;

import java.util.ArrayList;
import java.util.List;

public interface Tree <T>{
    void insert(T data);
    void delete(T data);
    List<T> inOrderTraversal();
    List<T> preOrderTraversal();
    List<T> postOrderTraversal();
    List<List<T>> levelOrderTraversal();
    boolean find(T data);
    T minInTree();
    T maxInTree();
}
