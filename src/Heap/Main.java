package Heap;

import java.util.Arrays;

class Score implements Comparable<Score>{
    private String subName;
    private int marks;

    public Score() {
    }

    public Score(String subName, int marks) {
        this.subName = subName;
        this.marks = marks;
    }

    @Override
    public int compareTo(Score o) {
        if (marks == o.marks) return 0;
        else if (marks > o.marks) return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "Score{" +
                "subName='" + subName + '\'' +
                ", marks=" + marks +
                '}';
    }
}

class MaxHeap{
    private Score[] heap;
    private int size;
    private int max_size;

    private int parent(int pos) { return (pos - 1) / 2; }
    private int left(int pos) { return (2 * pos) + 1; }
    private int right(int pos) { return (2 * pos) + 2; }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos)
    {
        Score tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void maxHeapify(int pos){
        System.out.println(pos + " " + isLeaf(pos));
        if (!isLeaf(pos) && left(pos) < size && right(pos) < size){
            System.out.println(pos + " " + heap[left(pos)].toString() + " " + heap[right(pos)].toString() );
            if (heap[pos].compareTo(heap[left(pos)]) == -1 || heap[pos].compareTo(heap[right(pos)]) == -1){
                if (heap[left(pos)].compareTo(heap[right(pos)]) == 1){
                    swap(pos, left(pos));
                    maxHeapify(left(pos));
                }else{
                    swap(pos, right(pos));
                    maxHeapify(right(pos));
                }
            }
        }
    }

    public MaxHeap(int max_size) {
        assert max_size >= 1 : "Size should be greater than 0";
        this.max_size = max_size;
        this.heap = new Score[max_size];
        this.size = 0;
    }

    public void insert(Score score){
        if (size == max_size) return;
        heap[size] = score;
        int curr = size;
        while(heap[curr].compareTo(heap[parent(curr)]) == 1){
            // swap until parent is smaller than current
            swap(curr, parent(curr));
            curr = parent(curr);
        }
        size++;
    }

    public Score pop(){
        Score popped = heap[0];
        heap[0] = heap[--size];
        maxHeapify(0);
        return popped;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "heap=" + Arrays.toString(heap) +
                ", size=" + size +
                ", max_size=" + max_size +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        MaxHeap scoreHeap = new MaxHeap(4);
        scoreHeap.insert(new Score("FDS", 120));
        scoreHeap.insert(new Score("ADS", 100));
        scoreHeap.insert(new Score("PS", 50));
        scoreHeap.insert(new Score("PS", 60));
        System.out.println(scoreHeap.toString());
        System.out.println(scoreHeap.pop().toString());
        System.out.println(scoreHeap.toString());
    }
}
