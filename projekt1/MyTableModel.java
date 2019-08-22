package projekt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModel extends ArrayList<Person> implements TableModel{
	private static final long serialVersionUID = 1L;
	String[] headers = {"LP", "Imiê", "Nazwisko", "Stanowisko", "Sta¿ pracy", "Pensja"};
	List<Person> myList = new ArrayList<Person>();
	
	public void setValueAt(Object val, int row, int col) {
		Person Person;
				
	    switch (col) {
	    	case 0 : myList.add(new Person("", "", "", 0, 0));
	    	case 1 : Person=myList.get(row); Person.setImie(val.toString()); break;
	    	case 2 : Person=myList.get(row); Person.setNazwisko(val.toString());break;
	    	case 3 : Person=myList.get(row); Person.setStanowisko(val.toString());break;
	    	case 4 : Person=myList.get(row); Person.setStazPracy(Integer.parseInt(val.toString()));break;
	    	case 5 : Person=myList.get(row); Person.setPensja(Integer.parseInt(val.toString()));break;
	    	default: break;
	    }
	}
	
	public MyTableModel(List<Person> myList, String headers[]){
		this.myList=myList;
		this.headers=headers;
	}
	
	public int getColumnCount() {return headers.length;	}	
	
	public boolean isCellEditable(int row, int col) {return false;}

	public Class<? extends Object> getColumnClass(int c) {
		if (myList.isEmpty()) return null;
		else return getValueAt(0, c).getClass();
		}
	
	public String getColumnName(int col) {return headers[col];}
	
	public int getRowCount() {	return myList == null ? 0 : myList.size();}
	
	public Object getValueAt(int row, int col) {
		Object o = null;
		try {
		Person Person=myList.get(row);			//stad idzie b³¹d przy remove
		switch (col) {
		   case 0 : o=Person.getLp();  break;
		   case 1 : o=Person.getImie(); break;
	       case 2 : o=Person.getNazwisko(); break;
	       case 3 : o=Person.getStanowisko(); break;
	       case 4 : o=Person.getStazPracy(); break;
	       case 5 : o=Person.getPensja(); break;
	       default: break;
	       }
		return o;
		}
		catch(Exception e){ e.getMessage(); }
		return null;
	}
	
	public String getValueAt1(int row, int col) {
		Person Person=myList.get(row);
		
		switch (col) {
		   case 1 : return Person.getImie();
	       case 2 : return Person.getNazwisko();
	       case 3 : return Person.getStanowisko();
	       default: return null; 
	       }
	}
	
	public int getValueAt2(int row, int col) {
		//Object o = null;
		Person Person=myList.get(row);;
		
		switch (col) {
		   case 0 : return Person.getLp();  
	       case 4 : return Person.getStazPracy(); 
	       case 5 : return Person.getPensja(); 
	       default: return 0; 
	       }
	}
	
	public String najTekst(int col, int m) {
		switch (col) {
		   case 1 : 
	       case 2 :
	       case 3 : String tab[]= new String[getRowCount()]; //zrob tablicê o d³ugoœci =liczba wierszy
	       			for (int i=0; i<tab.length; i++) {
	       				tab[i]=getValueAt1(i, col).toString();  //wype³nij tablicê kolejnymi wartosciami okreœlonej kolumny
	       			}
	       			Arrays.sort(tab);
	       			if (m==0) return tab[0]; //zwróæ wartoœæ danej komórki z pozycji 0 - jest ona najmniejsza
	       			else return tab[tab.length-1]; // zwróæ ostatni¹ - najwiêksza
	       default: return null;
	       }
	}
	
		public int najLiczba(int col, int m) {
			switch (col) {
			   case 0 : 
		       case 4 : 
		       case 5 : int tab[]= new int[getRowCount()]; 
		       			for (int i=0; i<tab.length; i++) {
		       				tab[i]=getValueAt2(i, col);
		       			}
		       			Arrays.sort(tab);
		       			if (m==0) return tab[0]; //zwróæ wartoœæ danej komórki z pozycji 0 - jest ona najmniejsza
		       			else return tab[tab.length-1]; 
		       default: return -100;
		       }
	}

	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
	}
}