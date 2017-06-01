
public class Tinker {

    public static void main(String[] args) {
        Speaker s = new Speaker();
        s.clearThroat();
        s.sayHi();
        s.sayBye();
        int a = s.doStuff(100);
        System.out.println(a);
    }

}
