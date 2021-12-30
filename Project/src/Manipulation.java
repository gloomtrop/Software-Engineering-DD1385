import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Manipulation extends JPanel{
    Model m;

    Manipulation(Model m){
        this.m = m;

        JTextField timeText = new JTextField("Change in time");
        JTextField lText = new JTextField("Change in vector length");

        timeText.setEditable(false);
        lText.setEditable(false);
        JScrollBar timeScrollBar = new JScrollBar(Scrollbar.VERTICAL,m.getTime(),1, 0,1000);
        JScrollBar lScrollBar = new JScrollBar(Scrollbar.VERTICAL,m.getL(),1, 0,20);

        timeScrollBar.setPreferredSize(new Dimension(20,100));
        lScrollBar.setPreferredSize(new Dimension(20,100));

        timeScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int time = e.getValue();
//                System.out.println(time);
                m.setTime(time);
            }
        });

        lScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int L = e.getValue();
                m.setL(L);
//                System.out.println(L);
            }
        });

        add(timeText, BorderLayout.WEST);

        add(timeScrollBar);

        add(lScrollBar);
        add(lText, BorderLayout.EAST);

        setSize(200,200);
    }
}
