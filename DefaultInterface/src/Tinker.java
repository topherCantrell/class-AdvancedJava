
interface Sad {
    void frown();
    
    default void express() {
        frown();
    }
}

interface Happy {
    void smile();
    
    default void express() {
        smile();
    }
}

class Face implements Sad, Happy {

    @Override
    public void frown() {
        System.out.println("Frown");
    }

    @Override
    public void smile() {
        System.out.println("smile");
    }

    @Override
    public void express() {
        // TODO Auto-generated method stub
        Happy.super.express();
    }
    
}

public class Tinker {

    public static void main(String[] args) {
        
        Face f = new Face();
        f.frown();
        f.smile();
        
    }

}
