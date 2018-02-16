package advprj;

import java.util.List;
import javafx.scene.text.Text;

public class TimerThread1 extends Thread
{
    private final Text time;
    int x;
    public TimerThread1(Text time,int x)
    {
        this.time = time;
        this.x=x;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        
        int tmp=x;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            time.setText("remain time:"+x--);
            if(x==0){
                x=tmp;
            }
        }
    }
}
