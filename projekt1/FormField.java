package projekt1;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FormField extends JFrame {
	private static final long serialVersionUID = 1L;
	JLabel jl;
    AddField pd;
    KeyEvent e;
	
    public FormField(String s) {
    	jl=new JLabel(s);
    	pd=new AddField(10);
    }
}