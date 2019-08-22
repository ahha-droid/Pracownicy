package projekt1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JPanelH extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	int szerokosc;
	int wysokosc;
	JOptionPane jop;
	
	public JPanelH(int szerokosc, int wysokosc) {
		super();
		setBackground(new Color(200, 255, 250));
		setPreferredSize(new Dimension(szerokosc, wysokosc));
		setBorder(BorderFactory.createRaisedBevelBorder());
	}
	public JPanelH(int szerokosc, int wysokosc, int i) {
		super();
		setBackground(new Color(200, 255, 250));
		setPreferredSize(new Dimension(szerokosc, wysokosc));
	}
	
	public JPanelH(int wysokosc) {this(1280, wysokosc);}
	
	public void actionPerformed(ActionEvent arg0) {System.out.print("");}
	
}