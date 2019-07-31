import java.util.HashMap;
import java.util.Scanner;

public class g1e5 {
    static HashMap<String, Double> vars;
    public static void main(String[] args) {
        vars = new HashMap();

        while(true) {
            Scanner sc = new Scanner(System.in);
            Double result = null;

            String line = sc.nextLine();
            sc = new Scanner(line);

            try {
                String operand1 = sc.next();
                String operator = sc.next();
                String operand2 = sc.next();

                if(sc.hasNext()) {
                    String second_operator = sc.next();
                    operand2 = Double.toString(doOperation(operand2, sc.next(), second_operator));
                }

                if(sc.hasNext()) throw new Exception("");
                result = doOperation(operand1, operand2, operator);

            } catch(IllegalArgumentException iae){
                System.err.println("\nErro! A variável não existe, logo não pode ser lida!\n");
                continue;
            }
            catch (Exception e) {
                System.err.println("\nErro! Input mal formado! Formato: <numero> <operador> <numero> OU <identificador> = <numero>\n");
                continue;
            }

            if(result != null) System.out.println("= " + result);
            System.out.println();
        }
    }

    static Double doOperation(String operand1, String operand2, String op) throws Exception {
        Double op1 = 0.0;
        Double op2 = 0.0;
        String new_var_name = null;
        Double result = null;

        if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
            op1 = getFinalValue(operand1);
            op2 = getFinalValue(operand2);
        }
        else if(op.equals("=")){
            if(isDouble(operand1)) throw new Exception("");
            new_var_name = operand1;
            op2 = getFinalValue(operand2);
        }

        if(op1 == null || op2 == null) throw new IllegalArgumentException("");

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
        case "=":
            vars.put(new_var_name, op2);
            result = null;
            break;
        default:
            System.err.println("\nErro! O operador indicado não é suportado.\n");
            throw new IllegalArgumentException();
        }
        return result;
    }

    static Double getFinalValue(String str){
        if(isDouble(str)) return Double.parseDouble(str);
        return vars.get(str);
    }

    static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}