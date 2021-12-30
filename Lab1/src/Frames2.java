import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frames2 extends JFrame{

    Frames2(){
        this.setTitle("Axels Frame");
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        this.add(panel);
        MyButton2 button = new MyButton2(Color.green, Color.red, "ON", "OFF");
        MyButton2 button2 = new MyButton2(Color.green, Color.red, "Run", "Stop");
        panel.add(button);
        panel.add(button2);

    }
    public static void main(String[] args) {
        Frames2 axelsFrame = new Frames2();
    }
}

class MyButton2 extends JButton implements ActionListener{
    private Color colorOne,colorTwo;
    private String stringOne, stringTwo;

    MyButton2(Color c1, Color c2, String s1, String s2){
        colorOne = c1;
        colorTwo = c2;
        stringOne = s1;
        stringTwo = s2;
        this.setText(stringOne);
        this.setBackground(colorOne);
        this.setVisible(true);

        // addActionListener function
        this.addActionListener(this::actionPerformed);

    }

    public void toggleState(){
        if (this.getText().equals(stringOne) && this.getBackground()==colorOne){
            this.setText(stringTwo);
            this.setBackground(colorTwo);
        }
        else{
            this.setText(stringOne);
            this.setBackground(colorOne);
        }

    }
    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.toggleState();
    }
}

