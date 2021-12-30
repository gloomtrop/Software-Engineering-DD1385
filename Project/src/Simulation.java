public class Simulation extends Thread{
    Model m;
    View v;
    Simulation(Model m, View v){
        this.m = m;
        this.v = v;
        new Thread(this).start();
    }

    public void run() {
        while (true) {
            try {
                sleep(m.getTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m.moveParticles();
            v.repaint();
        }
    }
}
