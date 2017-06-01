package utils;

public class StringUtilImpl implements StringUtil {
    
    @Override
    public String append(String a, String b) {
        return a+b;
    }
    
    @Override
    public String allCaps(String s) {
        return s.toUpperCase();
    }
    
}
