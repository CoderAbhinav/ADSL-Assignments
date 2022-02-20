package Assignment00;

public interface Tree <T> {
    void insert(T data);
    void delete(T key);
    boolean contains(T key);
}
