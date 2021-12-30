import java.util.ArrayList;

public class Model {
    private ArrayList<Particle> particles = new ArrayList<>();
    private int time = 50;
    Model(){
        int times = 10000;
        for(int i=0; i<times; i++){
            particles.add(new Particle());
        }
    }

    public void moveParticles(){
        for(Particle particle: particles){
            if (particle.movable){
                particle.randomMove();
            }
        }
    }

    public void setL(int l){
        for(Particle particle: particles){
            if (particle.movable){
                particle.changeL(l);
            }
        }
    }

    public int getL(){
        return particles.get(0).L;
    }

    public void setTime(int t){
        time = t;
    }

    public int getTime(){
        return time;
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }
}
