import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable {
    
    String label;
    
    public Worker(String label) {
        this.label = label;
    }
      
    @Override
    public void run() {
        for(int x=0;x<5;++x) {
            System.out.println(label+": Here!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
    
}

public class Tinker {

    public static void main(String[] args) {
        
        ExecutorService exec = Executors.newFixedThreadPool(5);
        
        for(int x=0;x<10;++x) {
            Worker w = new Worker("Thread"+x);
            exec.execute(w);
        }
        
        
    }

}
