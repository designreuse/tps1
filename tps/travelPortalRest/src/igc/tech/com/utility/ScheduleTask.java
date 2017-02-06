package igc.tech.com.utility;

import java.util.TimerTask;

/**
 * Created by tilak on 7/12/2016.
 */
public class ScheduleTask extends TimerTask {
  private Thread thread;

    @Override
    public void run() {
        thread.start();
    }

    public ScheduleTask(Thread t) {
        this.thread=t;
    }
}
