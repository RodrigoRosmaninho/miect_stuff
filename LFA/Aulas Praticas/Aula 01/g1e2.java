import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class g1e2 {
    public static void main(String[] args) {
        System.out.println("Equação: ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc = new Scanner(line);
        Stack<Double> s = new Stack<>();

        while(sc.hasNext()){
            if(sc.hasNextDouble()){
                s.push(sc.nextDouble());
            } else {
                String op = sc.next();
                
                if(op.length() != 1) {
                    System.err.println("\nErro! Input mal formado! Os operandos e operadores devem estar separados de espaços.");
                    System.exit(3);
                }
                if(s.size() < 2) {
                    System.err.println("\nErro! Input mal formado! Não há operandos suficientes na pilha para realizar a operação.");
                    System.exit(4);
                }

                double op1 = s.pop();
                double op2 = s.pop();
                double result = 0;
                switch (op) {
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
                        System.err.println("\nErro! O operador indicado não é suportado.");
                        System.exit(1);
                }
                s.push(result);
            }
        }

        if(s.size() != 1){
            System.err.println("\nErro! Input mal formado! Demasiados operandos na pilha.");
            System.exit(5);
        }

        System.out.println("= " + s.pop());
    }
}