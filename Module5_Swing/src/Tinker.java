import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class PressHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed 1");
    }    
}

interface Speak {
    public void sayHi();
}

interface MathOnOne {
    public int doMath(int first);
}

interface MathOnTwo {
    public int doMath(int first, int second);
}

class AddTwo implements MathOnTwo {
    @Override
    public int doMath(int first, int second) {
        return first + second;
    }    
}

class SubtractTwo implements MathOnTwo {
    @Override
    public int doMath(int first, int second) {
        return first - second;
    }    
}

public class Tinker {
    
    static int average(int one, int two) {
        return (one+two)/2;
    }
    
    static void process(BinaryOperator<Integer> operation) {
        System.out.println("-----");
        System.out.println(operation.apply(10, 20));
        System.out.println(operation.apply(0, 100));
        System.out.println(operation.apply(-5, 5));
    }
    
    
    static void process(IntBinaryOperator operation) {
        System.out.println("-----");
        System.out.println(operation.applyAsInt(10, 20));
        System.out.println(operation.applyAsInt(0, 100));
        System.out.println(operation.applyAsInt(-5, 5));
    }
    
    
    public static void main(String[] args) {
        
        //process(Tinker::average);
        
        //process(Math::min);
        
        //process(Math::max);
        
        
    }

}
