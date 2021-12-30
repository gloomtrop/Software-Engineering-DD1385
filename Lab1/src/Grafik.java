import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafik extends JFrame{
    public Grafik(){
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.RED);

        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
//        panel.setLayout(new BorderLayout());

        MyButton4 b1 = new MyButton4(Color.WHITE,Color.CYAN,"On","Off");
        panel.add(b1,BorderLayout.NORTH);
        this.add(panel);

        this.setVisible(true);
    }

    public static void main (String[] u) {
        new Grafik();
    }
}

class MyButton4 extends JButton implements ActionListener {
    private final Color Color1;
    private final Color Color2;
    private final String String1;
    private final String String2;

    public MyButton4(Color c1, Color c2, String s1, String s2){
        this.setText(s1);
        this.setBackground(c1);
        this.addActionListener(this::actionPerformed);
        Color1 = c1;
        Color2 = c2;
        String1 = s1;
        String2 = s2;
    }
    public void toggleState(){
        if (getBackground() == Color1){
            this.setText(String2);
            this.setBackground(Color2);
        }
        else{
            this.setText(String1);
            this.setBackground(Color1);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        toggleState();

    }

}