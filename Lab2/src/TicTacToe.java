public class TicTacToe implements Boardgame{
    private String[][] board = new String[3][3];   // spelplanen
    private boolean p1,p2;
    private int draws;

    TicTacToe(){
        p1 = true; p2 = false;
    }

    @Override
    public boolean move(int i, int j) {
        return false;
    }

    @Override
    public String getStatus(int i, int j) {
        return board[i][j];
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public int[] getLocation() {
        return new int[0];
    }

    //When the board is full, the game will erase the result
    //and start again
    public String[][] shiftGame(){
        return new String[3][3];
    }

    public static void main(String[] args) {
        Boardgame game = new TicTacToe();
    }
}

