import java.util.Scanner;
import java.lang.Exception;

public class g1e7 {
    public static void main(String[] args){
        ExpressionTree et = new ExpressionTree();
        Scanner sc = new Scanner(System.in);

        while(true){
            try {
                System.out.print("\nEquação: ");
                et.insert(sc.nextLine());
                System.out.println("Infix: " + et.printInfix());
                System.out.println("Resultado: " + et.eval());
            }  catch(Exception e){
                System.out.println("Expressão inválida!");
            }
        }
    }
}