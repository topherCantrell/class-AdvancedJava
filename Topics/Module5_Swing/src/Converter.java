import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Converter {
	
	public static void main(String[] args) {
		
	    JComboBox<String> from = new JComboBox<String>();
	    from.addItem("Inches");
	    from.addItem("Meters");
	    from.setSelectedIndex(0);

	    JComboBox<String> to = new JComboBox<String>();
	    to.addItem("Inches");
	    to.addItem("Meters");
	    to.setSelectedIndex(1);

	    JTextField value = new JTextField(15);
	    JTextArea history = new JTextArea(10,15);
	    JButton convert = new JButton("Convert");

	    JPanel panA = new JPanel(new FlowLayout());
	    panA.add(new JLabel("Convert"));
	    panA.add(from);
	    panA.add(new JLabel("to"));
	    panA.add(to);

	    JPanel panB = new JPanel(new BorderLayout());
	    panB.add(new JLabel("Value:"),BorderLayout.WEST);
	    panB.add(value,BorderLayout.CENTER);
	    
	    JPanel panC = new JPanel(new FlowLayout());
	    panC.add(convert);

	    JPanel panTop = new JPanel(new BorderLayout());
	    panTop.add(panA,"South");
	    panTop.add(BorderLayout.CENTER,panB);
	    panTop.add(BorderLayout.NORTH, panC);

	    JPanel panMain = new JPanel(new BorderLayout());	
	    panMain.add(BorderLayout.NORTH,panTop);
	    panMain.add(BorderLayout.CENTER,history);

	    JFrame jf = new JFrame("Converter");
	    jf.setContentPane(panMain);		
	    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    jf.setSize(250,320);
	    jf.setVisible(true);		
	    
	}


}
