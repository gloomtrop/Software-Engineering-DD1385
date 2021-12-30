import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class RPSSkel extends JFrame implements ActionListener {
    Gameboard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    Client clt;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;
    String myResult = "",sResult="";

    RPSSkel (Client client) throws IOException {
        clt = client;
        in = clt.getIn();
        out = clt.getUt();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        closebutton = new JButton("Close");
        closebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println("");out.flush();
                System.exit(0);
            }
        });
        myboard = new Gameboard("Myself", this::actionPerformed); // Must be changed
        computersboard = new Gameboard("Computer");
        JPanel boards = new JPanel();
        boards.setLayout(new GridLayout(1,2));
        boards.add(myboard);
        boards.add(computersboard);
        add(boards, BorderLayout.CENTER);
        add(closebutton, BorderLayout.SOUTH);
        setSize(350, 650);
        setVisible(true);
        out.println("Charlotta");
        out.flush();
        runClient();
    }

    void runClient() throws IOException {
        boolean running = true;
        while (running){
            sResult = in.readLine();
            if (!sResult.equals("Hello, Charlotta")){
                computersboard.setUpper(sResult);
            }
            if (sResult.equals("Bye Charlotta")){
                running = false;
            }
            comparison();
        }
    }

    void comparison(){
        if (sResult.equals("STEN") & myResult.equals("PASE")){
            myboard.wins();
            myboard.setLower("win");
            computersboard.setLower("lose");
        }
        else if (sResult.equals("PASE") & myResult.equals("SAX")){
            myboard.wins();
            myboard.setLower("win");
            computersboard.setLower("lose");
        }
        else if (sResult.equals("SAX") & myResult.equals("STEN")){
            myboard.wins();
            myboard.setLower("win");
            computersboard.setLower("lose");
        }
        else if (myResult.equals("STEN") & sResult.equals("PASE")){
            computersboard.wins();
            computersboard.setLower("win");
            myboard.setLower("lose");
        }
        else if (myResult.equals("PASE") & sResult.equals("SAX")){
            computersboard.wins();
            computersboard.setLower("win");
            myboard.setLower("lose");
        }
        else if (myResult.equals("SAX") & sResult.equals("STEN")){
            computersboard.wins();
            computersboard.setLower("win");
            myboard.setLower("lose");
        }
        else {
            myboard.setLower("draw");
            computersboard.setLower("draw");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton[] buttons = myboard.getButtons();
        JButton pressedButton = null;
        counter ++;

        for (int i = 0; i<buttons.length;i++){
            if (buttons[i] == e.getSource()){
                pressedButton = buttons[i];
            }
        }
        if (counter == 3) {
            myboard.markPlayed(pressedButton);
            assert pressedButton != null;

            myResult = e.getActionCommand();
            myboard.setUpper(myResult);
            out.println(myResult);out.flush();
            counter = 0;
        }
        else {
            myboard.resetColor();
        }
    }

    public static void main (String[] u) throws IOException {
        new RPSSkel(new Client());
    }
}

class Gameboard extends JPanel {

    private Icon[] icons = {new ImageIcon("rock.gif"),
            new ImageIcon("paper.gif"),
            new ImageIcon("scissors.gif")};

    private JButton[] buttons = new JButton[3];
    private JButton lastPlayed; // remembers last chosen button/gesture
    private String[] texts = {"STEN", "PASE", "SAX"};
    private JLabel upperMess, lowerMess, scorelabel;
    private int score;
    private Color bgcolor;
    private HashMap<String,JButton> map = new HashMap<String,JButton>();


    // Constructor that builds the board, used for computers board
    Gameboard(String name) {
        setLayout(new GridLayout(5,1));

        // Upper JPanel holds players name and last gesture played
        JPanel upper = new JPanel();
        upper.setLayout(new GridLayout(2,1));
        upper.add(new JLabel(name, JLabel.CENTER));
        upperMess = new JLabel("RPS", JLabel.CENTER);
        upper.add(upperMess);
        add(upper);

        // Lower JPanel has messages about the game and score
        JPanel lower = new JPanel();
        lower.setLayout(new GridLayout(2,1));
        lowerMess = new JLabel("win/lose/draw", JLabel.CENTER);
        scorelabel = new JLabel("Score: 0", JLabel.CENTER);
        lower.add(lowerMess); lower.add(scorelabel);

        for (int i = 0; i<3; i++){
            buttons[i] = new JButton(icons[i]);
            buttons[i].setActionCommand(texts[i]);
            add(buttons[i]);
            // Store each button in a map with its text as key.
            // Enables us to retrieve the button from a textvalue.
            map.put(texts[i],buttons[i]);
        }

        add(lower); // added after buttons
        bgcolor = buttons[0].getBackground();
        lastPlayed = buttons[0]; // arbitrary value at start
    }


    // Contructor for players board, puts listener on buttons
    Gameboard(String name, ActionListener listener) {
        this(name); // call other constructor to build the board
        for (int i = 0; i<3; i++)
            buttons[i].addActionListener(listener);
    }

    // reset yellow color
    void resetColor() {
        lastPlayed.setBackground(bgcolor);
    }

    void setUpper(String r) {
        upperMess.setText(r);
    }

    void setLower(String r) {
        lowerMess.setText(r);
    }

    // remember last chosen JButton and mark it yellow
    void markPlayed(String r) {
        lastPlayed = map.get(r);
        lastPlayed.setBackground(Color.yellow);
    }

    // or use JButton as parameter
    void markPlayed(JButton b) {
        lastPlayed = b;
        lastPlayed.setBackground(Color.yellow);
    }

    // add one point and display new score
    void wins() {
        score++;
        scorelabel.setText("Score: " + score);
    }
    public JButton[] getButtons(){
        return buttons;
    }
}
