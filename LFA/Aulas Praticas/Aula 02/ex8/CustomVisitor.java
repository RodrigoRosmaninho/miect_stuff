import java.util.HashMap;

public class CustomVisitor extends ex8BaseVisitor<Object> {

    public HashMap<String, Question> map = new HashMap();

    public Object visitQuestion(ex8Parser.QuestionContext ctx) {
        Question question = new Question(ctx.nome.getText());
        ctx.answer().stream().forEach(a -> {
            question.add(new Answer(a.STRING().getText(), Integer.parseInt(a.POINTS().getText())));
        });
        map.put(ctx.b.getText(), question);
        return null;
    }

}