package projekt1;

import javax.swing.JComboBox;
import javax.swing.JTable;

public class MyComboBox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	String tab[];
	
	public MyComboBox(String tab[]){
		super();
		for (int i=0; i< tab.length; i++) {addItem(tab[i]);}
	}
	
	public MyComboBox(JTable table, int j) {
		super();
		for (int i=0; i<table.getRowCount(); i++) {	addItem(""+table.getValueAt(i, j).toString()); }
	}
	
	public void nowe(JTable table, int j) {
		removeAllItems();
		try {
			for (int i=0; i<table.getRowCount(); i++) {		// mielismy lp 1,2,3,4, rowcount= 4, row=0,1,2,3 po usuniêciu -->> lp 1,3,4, rowcount= 4, row=0,1,2,
				try{addItem(table.getValueAt(i, j).toString());}
				catch(Exception e){ e.getMessage(); }
			}
		}
		catch(Exception e){ e.getMessage(); }
	}
	
	public void choose(FormField pf){
		try {pf.pd.setText(getSelectedItem().toString());}
		catch(Exception e){ e.getMessage(); }
	}
	
}