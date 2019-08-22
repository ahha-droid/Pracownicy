package projekt1;

import javax.swing.*;

public class AddField extends JTextField{
	
	private static final long serialVersionUID = 1L;
	JTextField jtf;

	public AddField(int arg0) {
		super(arg0);
		this.setBorder(BorderFactory.createLoweredSoftBevelBorder());
	}
	
	public boolean czyLiczba() {
		char[] tab = getText().toCharArray();
		int i=0;
		for(char c: tab) {
			int d=(int)c;
			if (d<48 || d>57) i=1;
		}
		boolean b=true;
		if (i!=0) b=false;
		return b;
	}
}