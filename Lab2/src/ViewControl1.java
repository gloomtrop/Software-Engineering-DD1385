import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewControl1 extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square1[][] board;        // Square är subklass till JButton
    private JLabel mess = new JLabel();  // JLabel funkar också

    ViewControl1(Boardgame gm, int n){  // OK med fler parametrar om ni vill!

        //Board
        board = new Square1[n][n];
        game = gm;
        //JFrame
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,200);

        //JPanel
        JPanel panelBoard = new JPanel(new GridLayout(n,n));
        JPanel panelLabel = new JPanel();
        panelLabel.setSize(500,5);
        this.add(panelBoard, "North");
        this.add(panelLabel, "South");

        //Fill the Grid
        for (int i = 0; i<n; i++){
            for(int j = 0;j<n; j++){
                Square1 sq1 = new Square1(i,j);
                board[i][j] = sq1;
                sq1.setText("Hej");
                sq1.addActionListener(this::actionPerformed);
                panelBoard.add(sq1);
                sq1.setVisible(true);
            }
        }
        panelLabel.add(mess);
        mess.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        Boardgame game = new TicTacToe();
        ViewControl board = new ViewControl(game, Integer.parseInt(args[0]));
    }
}

class Square1 extends JButton{
    int i,j;
    Square1(int row_index, int col_index){
    }
}