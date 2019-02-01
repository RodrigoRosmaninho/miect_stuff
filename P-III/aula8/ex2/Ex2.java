package aula8.ex2;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Ex2 {
    static JFrame frame;
    static JPanel image;
    static Bitmap bitmap;
    static String filename;

    public static void main(String[] args) throws IOException {
        frame = new JFrame();
        frame.setContentPane(getPanel());
        frame.setTitle("ImageViewer");
        File f = new File("aula8/ex2/image.png");
        Image i = ImageIO.read(f);
        frame.setIconImage(i);
        frame.setSize(500,450);
        frame.setVisible(true);
    }

    public static JPanel getPanel() throws IOException {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton b = (JButton) actionEvent.getSource();
                try {
                    listener(b.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        JPanel panel = new JPanel(new BorderLayout());
        image = getImage();
        panel.add(image,BorderLayout.CENTER);

        GridLayout grid = new GridLayout(1,5);
        JPanel embed = new JPanel(grid);
        panel.add(embed, BorderLayout.SOUTH);

        JButton button = new JButton("Shrink");
        button.setName("Shrink");
        button.addActionListener(al);
        embed.add(button);

        JButton button1 = new JButton("Flip Horizontal");
        button1.setName("FlipHorizontal");
        button1.addActionListener(al);
        embed.add(button1);

        JButton button2 = new JButton("Flip Vertical");
        button2.setName("FlipVertical");
        button2.addActionListener(al);
        embed.add(button2);

        JButton button3 = new JButton("Save");
        button3.setName("Save");
        button3.addActionListener(al);
        embed.add(button3);

        JButton button4 = new JButton("Save As");
        button4.setName("SaveAs");
        button4.addActionListener(al);
        embed.add(button4);

        return panel;
    }

    public static void listener(String button_id) throws IOException {
        switch(button_id){
            case "Shrink":
                bitmap = bitmap.shrink();
                redraw();
                break;
            case "FlipHorizontal":
                bitmap = bitmap.flipHorizontal();
                redraw();
                break;
            case "FlipVertical":
                bitmap = bitmap.flipVertical();
                redraw();
                break;
            case "Save":
                bitmap.reverseBytes().exportAsBMP(filename);
                break;
            case "SaveAs":
                bitmap.reverseBytes().exportAsBMP(getSavePath());
                break;
            default:
                break;
        }
    }

    public static void redraw(){
        frame.remove(image);
        image = new PanelImage(bitmap.data, Math.abs(bitmap.infoHeader.width), Math.abs(bitmap.infoHeader.height));
        frame.add(image, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public static PanelImage getImage() throws IOException {
        JFileChooser jfc = new JFileChooser();
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Bitmap Files (.bmp)","bmp", "BMP"));
        jfc.showOpenDialog(frame);
        File f = jfc.getSelectedFile();
        filename = f.getAbsolutePath();
        bitmap = new Bitmap(f).reverseBytes();
        return new PanelImage(bitmap.data, Math.abs(bitmap.infoHeader.width), Math.abs(bitmap.infoHeader.height));
    }

    public static String getSavePath(){
        JFileChooser jfc = new JFileChooser();
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Bitmap Files (.bmp)","bmp", "BMP"));
        jfc.showSaveDialog(frame);
        File f = jfc.getSelectedFile();
        return f.getAbsolutePath();
    }
}
