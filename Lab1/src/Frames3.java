import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frames3 extends JFrame implements ActionListener{

    MyButton3[] buttons;
    Frames3(String[] args){

        this.setTitle("Axels Frame");
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        this.add(panel);

        int i;
        int j = 0;
        // Making an array with ex number of MyButton objects from input in cmd
        buttons = new MyButton3[Integer.parseInt(args[0])];
        //Iterationg through every button and setting the attributed
        // while also attaching the object with an actionlistener
        // which is referenced to this Frame object which in turn
        // lets the JVM know to perform ActionPerformed when a Button is pressed
        for (i=0;i<Integer.parseInt(args[0]); i++){
            buttons[i] = new MyButton3(Color.green, Color.red, args[j+1],args[j+2]);
            panel.add(buttons[i]);
            j = j+2;
            buttons[i].addActionListener(this::actionPerformed);
        }
    }
    public static void main(String[] args) {
        Frames3 axelsFrame = new Frames3(args);
    }

    // Implementing overriding actionPerformed method
    // which goes though every button object
    // when the "click" action is made.
    // When the ActionEvent is invoked,
    // every object that has implemented
    // ActionListener gets this ActionEvent.
    // Then the method goes through every
    // button object and if the button object
    // that is pressed is not the one in the list,
    // the color is changed by calling the toggleState method in MyButtons
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i< buttons.length; i++){
            if (e.getSource() != buttons[i]){
                buttons[i].toggleState();
            }
        }


    }
}

class MyButton3 extends JButton{
    final private Color colorOne,colorTwo;
    final private String stringOne, stringTwo;

    MyButton3(Color c1, Color c2, String s1, String s2){
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

