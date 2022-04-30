package HashTable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class HashMap{
    private int size;
    private int[] arr;

    public HashMap(int size) {
        this.size = size;
        this.arr = new int[size];
        Arrays.fill(arr, -1);
    }

    private int hash(int value){
        int baseKey = value % size;
        if (this.arr[baseKey] == -1) return baseKey;
        int offset = 0;
        while (offset != size){
            if (this.arr[baseKey + offset] == -1) return (baseKey + offset);
            else if (this.arr[baseKey + offset] == value) return (baseKey + offset);
            offset++;
        }
        return -1;
    }

    public int insert(int value){
        int key = hash(value);
        if (key != -1) this.arr[key] = value;
        return key;
    }

    public int count(int value){
        int key = hash(value);
        if (key != -1 && this.arr[key] == value) return 1;
        return 0;
    }

    public boolean delete(int value){
        int key = hash(value);

        if (key != -1 && arr[key] != value) {
            System.out.println(key);
            arr[key] = value;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static int selection(){
        System.out.print("HASHMAP OPERATIONS\n1.INSET\n2.SEARCH\n3.DELETE\n0.EXIT\n> ");
        int sel = Integer.parseInt(sc.nextLine());
        return sel;
    }
    public static void main(String[] args) {
        int sel = -1;
        System.out.print("ENTER MAP SIZE\n> ");
        HashMap hm = new HashMap(Integer.parseInt(sc.nextLine()));
        while (sel != 0){
            System.out.println(hm.toString());
            sel = selection();
            if (sel == 1){
                System.out.print("ENTER THE VALUE\n> ");
                int res = hm.insert(Integer.parseInt(sc.nextLine()));
                if (res == -1) System.out.println("FALIED TO ADD");
                else System.out.println("SUCCESS");
            }else if (sel == 2){
                System.out.print("ENTER VALUE\n> ");
                int res = hm.count(Integer.parseInt(sc.nextLine()));
                if (res == 0) System.out.println("ELEMENT NOT FOUND!");
                else System.out.println("ELEMENT FOUND");
            }else if (sel == 3){
                System.out.print("ENTER VALUE\n> ");
                boolean res  = hm.delete(Integer.parseInt(sc.nextLine()));
                if (!res) System.out.println("FAILED");
                else System.out.println("SUCCESS");
            }
        }

        System.out.println("BYE!");

    }
}
