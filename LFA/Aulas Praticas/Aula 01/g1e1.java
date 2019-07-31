import java.util.Scanner;

public class g1e1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\nEquação: ");

            double op1 = 0;
            double op2 = 0;
            String op = "";
            try {
                op1 = sc.nextDouble();
                op = sc.next();
                op2 = sc.nextDouble();
            } catch (Exception e) {
                sc.nextLine();
                System.err.println("\nErro! Input mal formado! Formato: <numero> <operador> <numero>");
                continue;
            }

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
                continue;
            }

            System.out.println("= " + result + "\n");
        }
    }
}