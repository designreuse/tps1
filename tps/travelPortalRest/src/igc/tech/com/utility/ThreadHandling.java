package igc.tech.com.utility;

import java.util.concurrent.TimeUnit;


public class ThreadHandling implements Runnable{



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

    public ThreadHandling(String task) {
       this.task=task;

    }

    public static void main(String[] args) {

      new Thread(new ThreadHandling("task1")).start();


    }

}
