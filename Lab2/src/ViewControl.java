import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square[][] board;        // Square är subklass till JButton
    private JLabel mess = new JLabel();  // JLabel funkar också

    ViewControl(Boardgame gm, int n){  // OK med fler parametrar om ni vill!

        //Board
        board = new Square[n][n];
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
                String status = game.getStatus(i,j);
                Square sq1 = new Square(i,j,status);
                board[i][j] = sq1;
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
        int index_i = 0, index_j = 0;
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[i].length;j++){
                if (board[i][j] == e.getSource()){
                    Square sqr = board[i][j];
                    index_i = sqr.i;
                    index_j = sqr.j;
                    game.move(sqr.i, sqr.j);
                    String msg = game.getMessage();
                    mess.setText(msg);
                }
            }
        }
        if (mess.getText().equals("OK")){
            int[] loc_index = game.getLocation();
            String e_cell_t = board[loc_index[0]][loc_index[1]].getText();
            String press_cell_t = board[index_i][index_j].getText();

            board[loc_index[0]][loc_index[1]].setText(press_cell_t);
            board[index_i][index_j].setText(e_cell_t);
        }
    }

    public static void main(String[] args) {
        Boardgame game = new FifteenModel();
        ViewControl board = new ViewControl(game, Integer.parseInt(args[0]));
    }
}

class Square extends JButton{
    int i,j;
    Square(int row_index, int col_index, String status){
        i = row_index;j = col_index;
        this.setText(status);
    }
}
