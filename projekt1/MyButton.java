package projekt1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.TableRowSorter;

public class MyButton extends JButton //implements Border 
{
	private static final long serialVersionUID = 1L;
	FormField pf1, pf2, pf3, pf4, pf5;
	JScrollPane sp;
	List<Person> myList;
	JOptionPane jop;
	TableRowSorter<MyTableModel> sorter;
	
	public MyButton(String s) {super(s);}
		
	private void refreshing(JScrollPane sp) {
		sp.revalidate();
		sp.repaint();
	}
	
	private void refreshing(JScrollPane sp, TableRowSorter<MyTableModel> sorter) {
		refreshing(sp);
		sorter.setRowFilter(RowFilter.regexFilter(""));
	}
	
	private void refreshingCB(MyComboBox cbn, JTable table, MyComboBox cb2, JComboBox<String> cb3) {
		cbn.nowe(table, 0);
		int val2=cb3.getSelectedIndex();
		cb2.nowe(table, val2);
	}
	
	
	public void refresh(JScrollPane sp, List<Person> list, TableRowSorter<MyTableModel> sorter, JOptionPane jop, MyComboBox cbn, JTable table, MyComboBox cb2, JComboBox<String> cb3) {
		 if (list.isEmpty()) {((Messages) jop).emptyDB();}
		 else {refreshing(sp, sorter);
		 refreshingCB(cbn, table, cb2, cb3);}
	}
	
	public void add(FormField pf1, FormField pf2, FormField pf3, FormField pf4, FormField pf5, JScrollPane sp, List<Person> list, MyComboBox cbn, TableRowSorter<MyTableModel> sorter, JOptionPane jop, JTable table, MyComboBox cb2, JComboBox<String> cb3) {
		
		if (pf4.pd.czyLiczba()==true && pf5.pd.czyLiczba()==true) {
			if (pf1.pd.getText().equals("")||pf2.pd.getText().equals("")||pf3.pd.getText().equals("")||pf4.pd.getText().equals("")||pf5.pd.getText().equals("")) ((Messages) jop).clearFields();
			else {
				list.add(new Person(pf1.pd.getText(), pf2.pd.getText(), pf3.pd.getText(), Integer.parseInt(pf4.pd.getText()), Integer.parseInt(pf5.pd.getText())));
				pf1.pd.setText(""); pf2.pd.setText(""); pf3.pd.setText(""); pf4.pd.setText(""); pf5.pd.setText("");
				refreshingCB(cbn, table, cb2, cb3);
				refreshing(sp, sorter);
   			}
		}
		else ((Messages) jop).number2();
	}
	
	public void filtr(FormField pf, JComboBox<String> cb, JScrollPane sp, List<Person> list, TableRowSorter<MyTableModel> sorter, JOptionPane jop) {
		if (list.isEmpty()) ((Messages) jop).emptyDB();else {
			refreshing(sp, sorter);
			   if (pf.pd.getText().equals("")) ((Messages) jop).clearFields();else {
				   if (pf.pd.czyLiczba()==true) {
					   switch (cb.getSelectedItem().toString()) {
					   		case "Imiê" : sorter.setRowFilter(RowFilter.regexFilter(pf.pd.getText(), 1)); break;
				   			case "Nazwisko" : sorter.setRowFilter(RowFilter.regexFilter(pf.pd.getText(), 2)); break;
				   			case "Stanowisko" : sorter.setRowFilter(RowFilter.regexFilter(pf.pd.getText(), 3)); break;
				   			case "LP" : sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.EQUAL, Integer.parseInt(pf.pd.getText()), 0)); break;
				   			case "Sta¿ pracy" : sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.EQUAL, Integer.parseInt(pf.pd.getText()), 4)); break;
				   			case "Pensja" : sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.EQUAL, Integer.parseInt(pf.pd.getText()), 5)); break;
				   			default: break;
					   }
				   }
				   else {   
					   switch (cb.getSelectedItem().toString()) {
					   		case "Imiê" : sorter.setRowFilter(RowFilter.regexFilter(pf.pd.getText(), 1)); break;
					   		case "Nazwisko" : sorter.setRowFilter(RowFilter.regexFilter(pf.pd.getText(), 2)); break;
					   		case "Stanowisko" : sorter.setRowFilter(RowFilter.regexFilter(pf.pd.getText(), 3)); break;
					   		default: ((Messages) jop).number();
					   	}
				   }
			   }
			   refreshing(sp);
		   }
	}
	
	public void extremum2(int ext, JComboBox<String> cb, JScrollPane sp, List<Person> list, JOptionPane jop, TableRowSorter<MyTableModel> sorter, MyTableModel model, JLabel jl, String[] tab) {
		if (list.isEmpty()) ((Messages) jop).emptyDB();
		else {
			refreshing(sp, sorter);
			String extremumS="";
			int extremumL=0;
			int chooseMinMax;
			if (cb.getSelectedItem().toString().equals("Najmniejszej")) chooseMinMax=0; 
			else chooseMinMax=1;
			if (ext==0||ext==4||ext==5) {extremumL=model.najLiczba(ext, chooseMinMax); sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.EQUAL, extremumL, ext));}
				else if (ext==1||ext==2||ext==3) {extremumS=model.najTekst(ext, chooseMinMax); sorter.setRowFilter(RowFilter.regexFilter(extremumS, ext));}
			if (ext>=0 && ext<=5)jl.setText(tab[ext]);
			refreshing(sp);
 	   }
	}
	
	public void range(FormField pf, JComboBox<String> cb, JScrollPane sp, List<Person> list, JOptionPane jop, TableRowSorter<MyTableModel> sorter) {
		if (list.isEmpty()) ((Messages) jop).emptyDB();
		else {
			refreshing(sp, sorter);
			if (pf.pd.getText().equals("")) ((Messages) jop).clearFields();
			else {
			   if (pf.pd.czyLiczba()==true) {
				   int limit=Integer.parseInt(pf.pd.getText());
				   if (cb.getSelectedItem().equals("Mniejszej")) sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.BEFORE, limit, 5)); 
				   else sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.AFTER, limit, 5));
				   refreshing(sp);
			   }
			   else ((Messages) jop).number();
		   }
		}
	}
	
	public void remove(FormField pf, JScrollPane sp, List<Person> list, TableRowSorter<MyTableModel> sorter, JOptionPane jop, MyComboBox cbn, JTable table, MyComboBox cb2, JComboBox<String> cb3){
		if (list.isEmpty()) ((Messages) jop).emptyDB();
		else {
 		   		refreshing(sp, sorter);
		    	if (pf.pd.getText().equals("")) ((Messages) jop).clearFields();
		    	else {
		    		if (pf.pd.czyLiczba()==true) {
		    			int spr=0;
		    			for (int j=0; j<list.size(); j++) {
		    				if (Integer.parseInt(pf.pd.getText())==list.get(j).getLp()) {   
		    					list.remove(j);
		    					spr=1;
		    				}
		    			}
		    			if (spr==0) ((Messages) jop).wrongNr();
		    			else {refreshing(sp, sorter);
		    			refreshingCB(cbn, table, cb2, cb3);}
		    		}
		    		else ((Messages) jop).number();
		    		}
		   	}
	}
	
	public void save(FormField pf, JScrollPane sp, TableRowSorter<MyTableModel> sorter, JOptionPane jop, JTable table) {
		if (pf.pd.getText().equals("")) ((Messages) jop).emptyDB2();
		else {refreshing(sp, sorter);
			try{
				JFileChooser ch=new JFileChooser();
				int odp = ch.showSaveDialog(null);
				if (odp==JFileChooser.APPROVE_OPTION){ 
					File plik = ch.getSelectedFile();
					Pattern pattern = Pattern.compile("\\.");
					Matcher matcher = pattern.matcher(plik.getName());
					if (matcher.find()) ((Messages) jop).enlargement();
					else{
						BufferedWriter writer = new BufferedWriter(new FileWriter(plik+".txt"));
						for (int i=0; i<table.getRowCount(); i++) {
							for (int j=0; j<table.getColumnCount(); j++) {
								writer.write(""+table.getValueAt(i, j)); 
								writer.newLine();
							}
						}     
						writer.close();
					}
				}
			}
			catch(Exception e){ e.getMessage(); }
		}                 
	}
	
	public void load(JScrollPane sp, List<Person> list, JOptionPane jop, MyTableModel model, MyComboBox cbn, JTable table, MyComboBox cb2, JComboBox<String> cb3) {
		Scanner scaner=null;
		JFileChooser ch=new JFileChooser();
	    try {
	    	int odp = ch.showOpenDialog(null);
	    	if (odp==JFileChooser.APPROVE_OPTION) {
	    		File plik = ch.getSelectedFile();
	    		scaner = new Scanner(plik);
	    	    int licznik = 0;
	    	    while (scaner.hasNext()) { scaner.nextLine(); licznik++; }   scaner.close();
	    	    int row =licznik/model.getColumnCount();
	    		scaner = null;
	    		scaner = new Scanner(plik);
	    		
	    		int z=0;
	    		for (int i=0; i<row; i++) {
					for (int j=0; j<model.getColumnCount(); j++) {
						String var = String.valueOf(scaner.nextLine());
						switch (j) {
	    		    		   case 4 : 
	    		    		   case 5 : char[] tab = var.toCharArray();
	        		    				for(char c: tab) {int d=(int)c; if (d<48 || d>57) z=1; }; break;
	    		    		   default: break;
	    		    	 }
	    			}
				}
	    		
	    		scaner.close();
	    		scaner = null;
	    		
	    		if (z==0) {
	    			scaner = new Scanner(plik);
	    			Pattern pattern = Pattern.compile(".txt");
	    			Matcher matcher = pattern.matcher(plik.getName());
	    			if (matcher.find()) {
	    				Person.setI(1);
	    				list.clear();
	    				for (int i=0; i<row; i++) {
	    					for (int j=0; j<model.getColumnCount(); j++) {
	    						String var = String.valueOf(scaner.nextLine());
	    					 	model.setValueAt(var, i, j);
	    					}
	    				}
	    			}
	    			else ((Messages) jop).wrongEnlargment();
	    		}
	    		else ((Messages) jop).wrongDB();
	    		refreshing(sp);
	    		refreshingCB(cbn, table, cb2, cb3);
	    	} 
	    	scaner.close();
	    }
	    catch (Exception e) {e.getMessage(); }   
	}
	
}