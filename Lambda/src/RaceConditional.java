import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditional {

    public static void main(String[] args) {
        Data data= new Data();
        Thread t1=  new MyThread(data);
        Thread t2=  new MyThread(data);

        t1.start();
        t2.start();
    }
}

class Data {
   volatile int count;
   public Data(){

   }
}

class MyThread extends Thread{
    Data data;
    public MyThread(Data data){
        this.data = data;
    }

    public void sleep(int mSeconds){
      //  System.out.println(" delay = "+mSeconds);
        try {
            Thread.sleep(mSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
            while (data.count < 100) {
                synchronized (data) {
                    int  v = (int)( Math.random()*100);
                    sleep( v);

                    data.count++;
                    System.out.println("count =" + data.count + "  " + Thread.currentThread().getName());
                }
            }
    }
}
