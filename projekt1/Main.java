package projekt1;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;

public class Main extends JFrame{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {new Main();}});
		//SwingUtilities.invokeLater( () -> new Main() );
	}
	
	public Main() {
		List<Person> myList = new ArrayList<Person>();
		String[] headers = {"LP", "Imiê", "Nazwisko", "Stanowisko", "Sta¿ pracy", "Pensja"};
		MyTableModel model = new MyTableModel (myList, headers); 
		model.addTableModelListener(null);
		JOptionPane jop = new Messages();
		((Messages) jop).hello();
		
		Object[] options = {"Yes, please","No way!"};
		
		//utworzenie tabeli
		JTable table = new JTable (model);
		TableRowSorter<MyTableModel> sorter = new TableRowSorter<MyTableModel>(model);
		table.setRowSorter(sorter);
		
		TableCellRenderer cellRenderer = table.getDefaultRenderer(Integer.class);
		TableCellRenderer cellRenderer2 = table.getDefaultRenderer(char.class);
		((JLabel) cellRenderer).setHorizontalAlignment(JLabel.CENTER);
		((JLabel) cellRenderer2).setHorizontalAlignment(JLabel.CENTER);
				
		table.setFillsViewportHeight(true);
		table.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
		JScrollPane sp = new JScrollPane(table);
		
		//////Filtrowanie
		JPanel pTop = new JPanelH(1280, 200, 0);
		
		
		FormField pfFiltr=new FormField("Wprowadz szukan¹ wartoœæ: ");
		JComboBox<String> cbFiltr = new MyComboBox(headers);
		
		int val2 = cbFiltr.getSelectedIndex();
		System.out.println(val2);
		
		MyComboBox chooseProperty = new MyComboBox(table, val2);
		chooseProperty.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){chooseProperty.choose(pfFiltr);}});
		cbFiltr.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){chooseProperty.nowe(table, cbFiltr.getSelectedIndex());}});
		// wybór na cb zmienia jl
		
		MyButton bFiltr = new MyButton("Filtruj");
		bFiltr.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){ bFiltr.filtr(pfFiltr, cbFiltr, sp, myList, sorter, jop);}});
		
		JPanel pFiltr = new JPanelH(1000,50);
		pFiltr.add(new JLabel("FILTROWANIE: Wybierz kategoriê:"));
		pFiltr.add(cbFiltr);
		pFiltr.add(pfFiltr.jl);
		pFiltr.add(pfFiltr.pd);
		pFiltr.add(chooseProperty);
		pFiltr.add(bFiltr);
		
		pTop.add(pFiltr);
		////////////////////
		
		/////////Wyszukiwanie o najmniejszej i najwiekszej wartoœci danej cechy
		JPanel pExtremum = new JPanelH(1000,50);
		JLabel jlExtremum = new JLabel("");
		
		String naj[]= {"Najmniejszej", "Najwiêkszej"};
		JComboBox<String> cbNaj= new MyComboBox(naj);
		MyButton bChooseProperty = new MyButton("Wybierz cechê");
		
		bChooseProperty.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			int ext = JOptionPane.showOptionDialog(null, "Wybierz cechê:","Choose Property",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, headers, options[0]);
			bChooseProperty.extremum2(ext, cbNaj, sp, myList, jop, sorter, model, jlExtremum, headers);}});
		
		pExtremum.add(new JLabel("Wyszukaj pracownika o "));
		pExtremum.add(cbNaj);
		pExtremum.add(new JLabel("wartoœci cechy: "));
		pExtremum.add(jlExtremum);
		pExtremum.add(bChooseProperty);
		
		pTop.add(pExtremum);
		//////////////////			
		
		///////////Wyswietlenie pracowników o pensji ponizej lub ponizej danej wartosci
		JPanel pRange = new JPanelH(1000,50);
		String range[]= {"Wiêkszej", "Mniejszej"};
		JComboBox<String> cbRange= new MyComboBox(range);
		FormField pfRange = new FormField("ni¿: ");
		MyButton bRange = new MyButton("Wyœwietl");
		
		bRange.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){bRange.range(pfRange, cbRange, sp, myList, jop, sorter);}});
		
		pRange.add(new JLabel("Wyœwietl pracowników o pensji"));
		pRange.add(cbRange);
		pRange.add(pfRange.jl);
		pRange.add(pfRange.pd);
		pRange.add(bRange);
		
		pTop.add(pRange);
		////////////////
		
		MyComboBox chooseNb = new MyComboBox(table, 0);
		
		//Add pracownika
		JPanel pBottom = new JPanelH(1100, 200, 0);
		JPanel pAdd = new JPanelH(1000, 50);
		
		FormField pf1=new FormField(headers[1]);
		FormField pf2=new FormField(headers[2]);
		FormField pf3=new FormField(headers[3]);
		FormField pf4=new FormField(headers[4]);
		FormField pf5=new FormField(headers[5]);
		
		FormField[] windowsAdd = {pf1, pf2, pf3, pf4, pf5};
		for (FormField i: windowsAdd){pAdd.add(i.jl); pAdd.add(i.pd);	}
		
		MyButton bAdd = new MyButton("Dodaj");
		bAdd.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){	bAdd.add(pf1, pf2, pf3, pf4, pf5, sp, myList, chooseNb, sorter,jop, table, chooseProperty, cbFiltr);}});
		
		pAdd.add(bAdd);
		
		pBottom.add(pAdd);
		////////////////////////////////
		
		//usuñ pracownika
		FormField pfRemove=new FormField("Nr pracownika do usuniêcia z listy: ");
		chooseNb.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){chooseNb.choose(pfRemove);}});
		
		MyButton bRemove = new MyButton("Usuñ");
		bRemove.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){bRemove.remove(pfRemove, sp, myList, sorter,jop, chooseNb, table, chooseProperty, cbFiltr);}});
		
		JPanel pRemove = new JPanelH(598, 50);
		pRemove.add(pfRemove.jl);
		pRemove.add(pfRemove.pd);
		pRemove.add(chooseNb);
		pRemove.add(bRemove);
		
		pBottom.add(pRemove);
		///////////////////////
		
		/////odœwie¿anie
			MyButton bRefresh = new MyButton("Odœwie¿");
			bRefresh.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){bRefresh.refresh(sp, myList, sorter, jop, chooseNb, table, chooseProperty, cbFiltr);}});
			
			JPanel pRefresh = new JPanelH(398, 50);
			pRefresh.add(bRefresh);
			
			pBottom.add(pRefresh);
		///////
			
		///////zapis i odczyt z pliku
		JPanel pSave = new JPanelH(498, 50);
		JPanel pLoad = new JPanelH(498, 50);
		MyButton bSave=new MyButton("Zapisz DB do pliku");
		MyButton bLoad=new MyButton("Wczytaj DB z pliku");
			
		bSave.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event) {bSave.save(pfRemove, sp, sorter, jop, table);}});	
		bLoad.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event) {bLoad.load(sp, myList, jop, model, chooseNb, table, chooseProperty, cbFiltr);}});
			
		pSave.add(bSave);	
		pLoad.add(bLoad);	
		
		pBottom.add(pSave);
		pBottom.add(pLoad);
		/////////////////////			
		
		JPanel pLeft = new JPanelH(30, 600, 0);
		JPanel pRight = new JPanelH(30, 600, 0);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(190,230,235));
		panel.add(pTop, BorderLayout.PAGE_START);
		panel.add(pBottom, BorderLayout.PAGE_END);
		panel.add(pLeft, BorderLayout.WEST);
		panel.add(pRight, BorderLayout.EAST);
		panel.add(sp, BorderLayout.CENTER);
		
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1280, 720));
		frame.pack();
		frame.setVisible(true);		
	}
}