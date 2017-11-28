
public class SpeakerJNI {
    
    static {
        System.loadLibrary("libSayThings");
    }
    
    public void clearThroat() {
        System.out.println("Ahhh heeemmmm");
    }
    
    public void speakUp() {
        sayHi();
        sayBye();
    }
    
    public native void sayHi();
    
    public native void sayBye();
    
    public native int doStuff(int a);

}
