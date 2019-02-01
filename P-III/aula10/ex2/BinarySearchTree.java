package aula10.ex2;

import java.util.Iterator;
import java.lang.Comparable;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
    // o elemento do tipo T deve ser comparável para efectuar pesquisas
    // mas como pode herdar a implementação de compareTo() é mais correcto
    // usar <? super T>


    private static class BSTNode<T> {
        T element;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T theElement) {
            element = theElement;
            left = right = null;
        }
    }

    private BSTNode<T> root;
    private int numNodes;

    public BinarySearchTree() {
        root = null;
        numNodes = 0;
    }

    public void insert(T value) {
        root = insert(value, root);
        numNodes++;
    }

    private BSTNode<T> insert(T value, BSTNode<T> node) {
        if (node == null) return new BSTNode<>(value);
        if (value.compareTo(node.element) > 0) node.right = insert(value, node.right);
        if (value.compareTo(node.element) < 0) node.left = insert(value, node.left);
        return node;
    }

    private void insert(BSTNode<T> value, BSTNode<T> node) {
        if(root == null) root = value;
        if (value.element.compareTo(node.element) > 0) {
            if(node.right == null) node.right = value;
            else insert(value, node.right);
        }
        if (value.element.compareTo(node.element) < 0) {
            if(node.left == null) node.left = value;
            else insert(value, node.left);
        }
    }

    public void remove(T value) {
        root = remove(value, root);
        numNodes--;
    }

    private BSTNode<T> remove(T value, BSTNode<T> node) {
        if(node == null) return null;
        if (node.right != null && node.right.element.compareTo(value) == 0){
            BSTNode<T> right = node.right.right;
            BSTNode<T> left = node.right.left;
            node.right = null;
            if(right != null) insert(right, root);
            if(left != null) insert(left, root);
        }
        else if (node.left != null && node.left.element.compareTo(value) == 0){
            BSTNode<T> right = node.left.right;
            BSTNode<T> left = node.left.left;
            node.left = null;
            if(right != null) insert(right, root);
            if(left != null) insert(left, root);
        }
        else{
            if (node.element.compareTo(value) < 0) {
                node.right = remove(value, node.right);
            }
            if (node.element.compareTo(value) > 0) {
                node.left = remove(value, node.left);
            }
        }
        return node;
    }

    public boolean contains(T value) {
        return find(value, root) != null;
    }

    private BSTNode<T> find(T value, BSTNode<T> node){
        if(node == null) return null;
        if(node.element.compareTo(value) == 0) return node;
        if(node.element.compareTo(value) < 0) return find(value, node.right);
        if(node.element.compareTo(value) > 0) return find(value, node.left);
        return null;
    }

    public Iterator<T> iterator() {
        return new TreeIterator();
    }

    class TreeIterator implements Iterator<T>{
        Stack<BSTNode<T>> stack;

        public TreeIterator(){
            stack = new Stack<>();
            stack.add(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public T next() {
            BSTNode<T> node = stack.pop();
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
            return node.element;
        }
    }
}
