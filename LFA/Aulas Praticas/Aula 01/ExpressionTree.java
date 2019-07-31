import java.util.Iterator;
import java.util.Scanner;
import java.lang.Comparable;
import java.util.Stack;

public class ExpressionTree {

    private static class Node {
        String element;
        Node left;
        Node right;

        Node(String theElement) {
            element = theElement;
            left = right = null;
        }
    }

    private Node root;

    public ExpressionTree() {}

    public void insert(String str) {
        Scanner sc = new Scanner(str);
        root = insert(sc, root);
        if(sc.hasNext()) throw new IllegalArgumentException();
    }

    private Node insert(Scanner sc, Node node) {
        if(!sc.hasNextDouble()) {
            node = new Node(sc.next());
            node.left = insert(sc, node.left);
            node.right = insert(sc, node.right);
        } else node = new Node(sc.next());
        return node;
    }

    public String printInfix(){
        if(root == null) throw new NullPointerException();
        return printInfix(root);
    }

    private String printInfix(Node node) {
        if(node.right == null || node.left == null) return node.element;
        return printInfix(node.left) + " " + node.element + " " + printInfix(node.right);
    }

    public Double eval(){
        if(root == null) throw new NullPointerException();
        return eval(root);
    }

    private Double eval(Node node){
        if(node.right == null || node.left == null) return Double.parseDouble(node.element);

        double op1 = eval(node.left);
        double op2 = eval(node.right);
        Double result = null;
        switch (node.element) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
            default:
                break;
        }
        return result;
    }
}
