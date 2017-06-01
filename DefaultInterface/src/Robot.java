
public class Robot implements Animal, Computer {

    @Override
    public void sayHi() {
    }

    @Override
    public void sayBye() { 
    }

    @Override
    public void takeNap() {
        Computer.super.takeNap();
    }

    

}
