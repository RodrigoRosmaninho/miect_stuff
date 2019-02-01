package aula10.ex2;

import java.util.Iterator;

public class TestTree {
    public static void main(String[] args){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] elems = new int[]{6,3,8,12,9,2,5,1,4,7,11,15};
        for(int i : elems) bst.insert(i);
        System.out.println(bst.contains(4)); // true
        bst.remove(4);
        System.out.println(bst.contains(4) + "\n"); // false

        printSet(bst.iterator());
    }

    public static void printSet(Iterator i){
        while(i.hasNext()) System.out.println(i.next());
    }
}
