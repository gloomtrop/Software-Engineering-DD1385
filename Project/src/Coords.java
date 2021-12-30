import java.util.Objects;

public class Coords {
    int x, y;
    Coords (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int compareTo(Coords other) {
        if((this.x == other.y) &(this.y == other.y)){
            return 3;
        }
        else if ((this.x == other.y) & (Math.abs(this.y-other.y))==1){
            return -1;
        }

        else if ((this.y== other.y) & (Math.abs(this.x-other.x))==1){
            return 1;
        }
        else if((Math.abs(this.y-other.y)==1) & (Math.abs(this.x-other.x)==1)){
            return 2;
        }
        return 0;
    }
}
