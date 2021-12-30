import java.util.concurrent.ThreadLocalRandom;

public interface Boardgame {

    public boolean move(int i, int j); //ger true om draget gick bra, annars false
    public String getStatus(int i, int j); // returnera innehåll på ruta (i,j)
    public String getMessage(); // returnera OK (eller liknande) eller felmeddelande avseende senaste drag
    public int[] getLocation();

    public static void main(String[] args) {
//        Boardgame game = new FifteenModel();
    }
}

class FifteenModel implements Boardgame {

    private String currentMessage = "No message yet";
    private String[][] board = new String[4][4];   // spelplanen
    private int iemp, jemp;                // index till den tomma rutan
    private int prev_iemp,prev_jemp;

    FifteenModel(){
        //        String[] arr = {"10", "9","6","4","1", " ", "7", "8", "5",
        //        "14", "2", "3", "11", "13", "15", "12"};
        //Initialize board

        int num = 1;
        //Adding nums to table
        for (int i = 0; i< board.length;i++){
            for (int j = 0; j<board.length; j++) {
                if (i == board.length && j == board.length){
                    iemp = i;jemp = j;
                    board[iemp][jemp] = " ";
                }
                else {
                    board[i][j] = Integer.toString(num);
                }
                num++;
            }
        }
        //Randomize the table
        for (int i= 0; i<100; i++){
//            int randInt = rand.nextInt((-1 +1)+1)-1;
            int randInt = ThreadLocalRandom.current().nextInt(-1, 1 + 1);
            if ((iemp == 0 || jemp == 0) & randInt == -1){
                if (iemp != 0){
                    move(iemp + randInt, jemp);
                }
                else if (jemp != 0) {
                    move(iemp, jemp + randInt);
                }
                else {
                    int randchoice = ThreadLocalRandom.current().nextInt(0, 1 + 1);
//                    System.out.println("choice 0" + randchoice + " iemp, jemp " + iemp + " "+jemp);
                    if (randchoice == 0){
                        move(iemp - randInt,jemp);
                    }
                    else{
                        move(iemp, jemp - randInt);
                    }
                }
            }
            else if ((iemp == 3 || jemp == 3) & randInt == 1){
                if (iemp != 3){
                    move(iemp + randInt, jemp);
                }
                else if (jemp != 3) {
                    move(iemp, jemp + randInt);
                }
                else {
                    int randchoice = ThreadLocalRandom.current().nextInt(0, 1 + 1);
//                    System.out.println("choice 4" + randchoice+ " iemp, jemp " + iemp + " "+jemp);
                    if (randchoice == 0){
                        move(iemp - randInt,jemp);
                    }
                    else{
                        move(iemp, jemp - randInt);
                    }
                }
            }
            else {
                int randchoice = ThreadLocalRandom.current().nextInt(0, 1 + 1);
//                System.out.println("choice N" + randchoice+ " iemp, jemp " + iemp + " "+jemp);
                if (randchoice == 0){
                    move(iemp + randInt,jemp);
                }
                else{
                    move(iemp, jemp + randInt);
                }

            }
        }

    }
    @Override
    public boolean move(int i, int j) {
        if (i > board.length || j > board.length || i <0 || j <0){
            currentMessage = "Please choose a position within the board!";
            return false;
        }
        else {
            if (Math.sqrt(Math.pow((i-iemp),2) + Math.pow((j-jemp),2)) == 1){
                board[iemp][jemp] = board[i][j];
                board[i][j] = " ";
                prev_iemp = iemp;
                prev_jemp = jemp;
                iemp = i;jemp=j;
                currentMessage = "OK";
                return true;
            }
        }
        currentMessage = "Please choose a position next to the empty one!";
        return false;
    }

    @Override
    public String getStatus(int i, int j) {
        return board[i][j];
    }

    @Override
    public String getMessage() {
        return currentMessage;
    }

    @Override
    public int[] getLocation() {
        int[] loc = new int[]{prev_iemp,prev_jemp};
        return loc;
    }
    // Implementera Boardgame-metoderna
    // Deklarera variabler och övriga metoder som ni
    // tycker behövs för ett femtonspel

}

