package aula8.ex3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

public class Ex3 {
    static QQSM game;
    static JFrame frame;
    static JTextArea question;
    static JLabel money;
    static ButtonGroup group;


    public static void main(String[] args){
        game = new QQSM();
        frame = new JFrame();
        JPanel root_panel = new JPanel(new BorderLayout());
        root_panel.add(getImage(), BorderLayout.LINE_START);
        root_panel.add(getQuestion(), BorderLayout.LINE_END);
        root_panel.add(getMoney(), BorderLayout.PAGE_START);
        root_panel.add(getButtons(), BorderLayout.PAGE_END);
        frame.setContentPane(root_panel);
        frame.setSize(500,500);
        frame.setTitle("Quem Quer Ser Milionário?");
        frame.setVisible(true);
    }

    public static JPanel getImage(){
        JPanel image = new JPanel();
        JLabel label = new JLabel();
        try{
            File f = new File("");//game.getImage());
            ImageIcon ii = new ImageIcon(ImageIO.read(f));
            label.setIcon(ii);

        } catch(Exception e){
            //throwError("");
        }
        image.add(label);
        return image;
    }

    public static JPanel getQuestion(){
        JPanel panel = new JPanel();
        question = new JTextArea();
        question.setText("");//game.getQuestion());
        panel.add(question);
        return panel;
    }

    public static JPanel getMoney(){
        JPanel panel = new JPanel(new BorderLayout());
        money = new JLabel();
        //money.setText(game.getMoney() + "€");
        panel.add(money, BorderLayout.LINE_END);
        return panel;
    }

    public static JPanel getButtons(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    AbstractButton b = (AbstractButton) actionEvent.getSource();
                    listener(b.getName());
                } catch (Exception e) {
                    //throwError("");
                }
            }
        };

        JPanel panel = new JPanel(new BorderLayout());

        JPanel ajudas = new JPanel();

        JToggleButton ajuda1 = new JToggleButton();
        ajuda1.setName("ajuda1");
        ajuda1.addActionListener(al);
        ajudas.add(ajuda1);

        JToggleButton ajuda2 = new JToggleButton();
        ajuda2.setName("ajuda2");
        ajuda2.addActionListener(al);
        ajudas.add(ajuda2);

        JToggleButton ajuda3 = new JToggleButton();
        ajuda3.setName("ajuda3");
        ajuda3.addActionListener(al);
        ajudas.add(ajuda3);

        panel.add(ajudas, BorderLayout.PAGE_START);

        String[] opcoes = null;//game.getOptions();

        JPanel opcoes1 = new JPanel(new GridLayout(2,1));

        JRadioButton opcao1 = new JRadioButton();
        opcao1.setText(opcoes[0]);

        JRadioButton opcao2 = new JRadioButton();
        opcao2.setText(opcoes[1]);

        opcoes1.add(opcao1);
        opcoes1.add(opcao2);

        JPanel opcoes2 = new JPanel(new GridLayout(2,1));

        JRadioButton opcao3 = new JRadioButton();
        opcao3.setText(opcoes[2]);

        JRadioButton opcao4 = new JRadioButton();
        opcao4.setText(opcoes[3]);

        opcoes2.add(opcao3);
        opcoes2.add(opcao4);

        panel.add(opcoes1, BorderLayout.LINE_START);
        panel.add(opcoes2, BorderLayout.CENTER);

        group = new ButtonGroup();
        group.add(opcao1);
        group.add(opcao2);
        group.add(opcao3);
        group.add(opcao4);

        JPanel decision = new JPanel();

        JButton cancel = new JButton("Desistir");
        cancel.setName("cancel");
        cancel.addActionListener(al);

        JButton confirm = new JButton("Confirmar");
        confirm.setName("confirm");
        confirm.addActionListener(al);

        decision.add(cancel);
        decision.add(confirm);

        panel.add(decision, BorderLayout.LINE_END);

        return panel;
    }

    public static void listener(String button_id) {
        int[] res;
        Enumeration<AbstractButton> e = group.getElements();
        switch(button_id){
            case "ajuda1":
                String ans = "";
                res = null;//game.useHelp(1);
                for(int i : res){
                    JRadioButton b = (JRadioButton) e.nextElement();
                    ans += b.getText() + ": " + i + "%\n";
                }
                JOptionPane.showMessageDialog(frame, "", "Ajuda do Público", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "ajuda2":
                res = null;//game.useHelp(2);
                break;
            case "ajuda3":
                res = null;//game.useHelp(3);
                for(int i : res){
                    JRadioButton b = (JRadioButton) e.nextElement();
                    if(i < 0) b.setEnabled(false);
                }
                break;
            case "cancel":
                //bitmap.reverseBytes().exportAsBMP(filename);
                break;
            case "confirm":
                //bitmap.reverseBytes().exportAsBMP(getSavePath());
                break;
            default:
                break;
        }
    }
}
