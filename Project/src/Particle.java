import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Particle{
    private double x ,y , theta;
    int L = 3;
    Color color;
    boolean movable = true;

    Particle(){
        color = Color.RED;
        randomTheta();
        Random r = new Random();
        x = 200 * r.nextDouble();
        y = 200 * r.nextDouble();
    }

//    Particle(double x, double y){
//        color = Color.RED;
//        this.x= x; this.y= y;
//    }

    private void randomTheta(){
        Random r = new Random();
        theta = 2*Math.PI * r.nextDouble();

    }
    public void randomMove(){
        randomTheta();
        x = x + L*Math.cos(theta);
        y = y + L*Math.sin(theta);
    }

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    public void changeL(int l){L = l;}
}
