import java.io.FileInputStream;
import java.util.HashSet;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;

public class ex8Main {
   public static void main(String[] args) throws Exception {
      // create a CharStream that reads from standard input:
      if(args.length != 3){
         System.err.println("Wrong argument number");
         System.exit(1);
      }

      CharStream input = CharStreams.fromStream(new FileInputStream(args[0]));
      // create a lexer that feeds off of input CharStream:
      ex8Lexer lexer = new ex8Lexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      ex8Parser parser = new ex8Parser(tokens);
      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());
      // begin parsing at program rule:
      ParseTree tree = parser.program();
      if (parser.getNumberOfSyntaxErrors() == 0) {
         // print LISP-style tree:
         // System.out.println(tree.toStringTree(parser));
         CustomVisitor visitor0 = new CustomVisitor();
         visitor0.visit(tree);

         // Custom Code:
         Question question = visitor0.map.get(args[1]);
         if(question != null){
            if(Integer.parseInt(args[2]) > question.size()) {
               System.err.println("Not enough answers");
               System.exit(3);
            }
            HashSet<Answer> set = new HashSet();
            while(set.size() != Integer.parseInt(args[2])){
               int index = (int)(Math.random() * question.size());
               set.add(question.get(index));
            }

            System.out.printf("- %s\n", question.getQuestion());
            int i = 0;
            for (Answer answer : set) System.out.printf("\t%s) %s\n", (char)('a' + i++), answer.getAnswer());
         }
         else{
            System.err.println("Question does not exist");
            System.exit(2);
         }
      }
   }
}
