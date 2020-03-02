
public class TinkerJNI {

    public static void main(String[] args) {
        SpeakerJNI s = new SpeakerJNI();
        s.clearThroat();
        s.sayHi();
        s.sayBye();
        int a = s.doStuff(100);
        System.out.println(a);
    }

}
