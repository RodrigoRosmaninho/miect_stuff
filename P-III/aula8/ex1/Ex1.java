package aula8.ex1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

public class Ex1 {
    static JogoDoGalo jogo;
    static JFrame frame;

    public static void main(String[] args) throws IOException {
        try {
            jogo = new JogoDoGalo(args[0]);
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null,"Erro! O programa necessita de 1 argumento!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        frame = new JFrame();
        frame.setContentPane(getPanel());
        frame.setTitle("Jogo do Galo");
        File f = new File("aula8/ex1/galo.png");
        Image i = ImageIO.read(f);
        frame.setIconImage(i);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public static JPanel getPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        for(int i = 0; i < 9; i++){
            JToggleButton b = new JToggleButton();
            final int id = i;
            b.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent itemEvent) {
                    String s = JogoDoGalo.getStringFromInt(jogo.getNext());
                    if(jogo.play(id)) {
                        JToggleButton b = (JToggleButton) itemEvent.getItem();
                        b.setText(s);
                        b.setEnabled(false);
                        int res = jogo.checkVictory();
                        if (res == 1 || res == 2) {
                            JOptionPane.showMessageDialog(frame, "O jogador " + JogoDoGalo.getStringFromInt(res) + " ganhou o jogo!", "Vitória", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                        else if (res == 3) {
                            JOptionPane.showMessageDialog(frame, "O jogo acabou em empate!", "Empate", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                    }
                }
            });
            Font f = b.getFont();
            String fam = f.getFamily();
            int style = f.getStyle();
            b.setFont(new Font(fam,style,64));
            panel.add(b);
        }
        return panel;
    }
}
