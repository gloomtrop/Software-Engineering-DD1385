import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frames extends JFrame implements ActionListener{
    MyButton button;
    Frames(){
        this.setTitle("Axels Frame");
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        this.add(panel);
        button = new MyButton(Color.green, Color.red, "ON", "OFF");
        panel.add(button);

        button.addActionListener(this::actionPerformed);
    }

    public static void main(String[] args) {
        Frames axelsFrame = new Frames();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.toggleState();
    }
}

class MyButton extends JButton{
    private final Color colorOne;
    private final Color colorTwo;
    private final String stringOne;
    private final String stringTwo;

    MyButton(Color c1, Color c2, String s1, String s2){
        colorOne = c1;
        colorTwo = c2;
        stringOne = s1;
        stringTwo = s2;
        this.setText(stringOne);
        this.setBackground(colorOne);
        this.setVisible(true);

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
}
