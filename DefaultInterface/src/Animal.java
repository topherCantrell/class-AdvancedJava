public interface Animal {
    
    public void sayHi();
    
    public void sayBye();
    
    default public void takeNap() {
        System.out.println("ZZZzzz...");
    }
    
}
