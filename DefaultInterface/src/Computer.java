
public interface Computer {
    
    public void sayHi();
    
    default public void takeNap() {
        System.out.println("101010 ...");
    }

}
