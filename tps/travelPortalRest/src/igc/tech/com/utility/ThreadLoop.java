package igc.tech.com.utility;

import java.util.concurrent.TimeUnit;

/**
 * Created by tilak on 7/12/2016.
 */
public class ThreadLoop implements Runnable{

    private static int count=0;

    private  String  task ;

    @Override
    public void run() {

        for (int i=0; i<=10; i++){

            System.out.println("Thread:"+task+ "value="+i);

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ThreadLoop(String task) {
       this.task=task;
    }

    public static void main(String[] args) {

      new Thread(new ThreadLoop("task1")).start();

        System.out.println("testing1");
      new Thread(new ThreadLoop("task2")).start();

        System.out.println("testing2");
    }

}
