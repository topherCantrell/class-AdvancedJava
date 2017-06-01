
class Speaker implements Runnable {

    @Override
    public void run() {

        System.out.println("Run starting");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Run ending");
    }

}

class Spinner implements Runnable {
    @Override
    public void run() {
        while(true);        
    }    
}

public class Tinker3 {

    public static void main(String[] args) throws Exception {

        Spinner sp = new Spinner();
        
        for(int x=0;x<6;++x) {
            Thread mgr = new Thread(sp);                       
            mgr.start();
        }         

    }

}
