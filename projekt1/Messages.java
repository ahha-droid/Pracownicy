package projekt1;

import javax.swing.JOptionPane;

public class Messages extends JOptionPane {
	private static final long serialVersionUID = 1L;

	public void hello() {JOptionPane.showMessageDialog(null, "Mi³ej zabawy :)", "Employers DB", JOptionPane.INFORMATION_MESSAGE);}
	
	public void emptyDB() {JOptionPane.showMessageDialog(null, "Zaimportuj DB", "Pusta DB!", JOptionPane.WARNING_MESSAGE);}
	
	public void emptyDB2() {JOptionPane.showMessageDialog(null, "Nie mo¿na zapisaæ pustej DB", "pusta DB", JOptionPane.WARNING_MESSAGE);}
	
	public void enlargement() {JOptionPane.showMessageDialog(null, "Aby zapisaæ DB wprowadz nazwê bez rozszerzenia", "Wprowadzono rozszerzenie", JOptionPane.WARNING_MESSAGE);}
	
	public void number() {JOptionPane.showMessageDialog(null, "Pole tej kategorii musi byæ uzupe³nione wartoœci¹ liczbow¹", "Wymagana wartoœæ liczbowa!!", JOptionPane.WARNING_MESSAGE);}
	
	public void clearFields() {JOptionPane.showMessageDialog(null, "Uzupe³nij wszystkie pola", "Czyste pola", JOptionPane.WARNING_MESSAGE);}
	
	public void wrongEnlargment() {JOptionPane.showMessageDialog(null, "Aby wczytaæ DB wybierz plik txt", "Nieprawid³owe rozszerzenie", JOptionPane.WARNING_MESSAGE);}
	
	public void wrongDB() {JOptionPane.showMessageDialog(null, "DB zawiera b³êdnie sformatowane dane", "B³êdne dane", JOptionPane.WARNING_MESSAGE);}
	
	public void wrongNr() {JOptionPane.showMessageDialog(null, "Pracownik o podanym numerze nie istnieje", "Nieprawid³owy numer", JOptionPane.WARNING_MESSAGE);}
	
	public void number2() {JOptionPane.showMessageDialog(null, "Pola kategorii \"Sta¿ Pracy\" i \"Pensja\" musz¹ byæ uzupe³nione wartoœc¹ liczbow¹", "Wymagana wartoœæ liczbowa!!", JOptionPane.WARNING_MESSAGE);}
	
}
