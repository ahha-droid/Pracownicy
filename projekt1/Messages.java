package projekt1;

import javax.swing.JOptionPane;

public class Messages extends JOptionPane {
	private static final long serialVersionUID = 1L;

	public void hello() {JOptionPane.showMessageDialog(null, "Mi�ej zabawy :)", "Employers DB", JOptionPane.INFORMATION_MESSAGE);}
	
	public void emptyDB() {JOptionPane.showMessageDialog(null, "Zaimportuj DB", "Pusta DB!", JOptionPane.WARNING_MESSAGE);}
	
	public void emptyDB2() {JOptionPane.showMessageDialog(null, "Nie mo�na zapisa� pustej DB", "pusta DB", JOptionPane.WARNING_MESSAGE);}
	
	public void enlargement() {JOptionPane.showMessageDialog(null, "Aby zapisa� DB wprowadz nazw� bez rozszerzenia", "Wprowadzono rozszerzenie", JOptionPane.WARNING_MESSAGE);}
	
	public void number() {JOptionPane.showMessageDialog(null, "Pole tej kategorii musi by� uzupe�nione warto�ci� liczbow�", "Wymagana warto�� liczbowa!!", JOptionPane.WARNING_MESSAGE);}
	
	public void clearFields() {JOptionPane.showMessageDialog(null, "Uzupe�nij wszystkie pola", "Czyste pola", JOptionPane.WARNING_MESSAGE);}
	
	public void wrongEnlargment() {JOptionPane.showMessageDialog(null, "Aby wczyta� DB wybierz plik txt", "Nieprawid�owe rozszerzenie", JOptionPane.WARNING_MESSAGE);}
	
	public void wrongDB() {JOptionPane.showMessageDialog(null, "DB zawiera b��dnie sformatowane dane", "B��dne dane", JOptionPane.WARNING_MESSAGE);}
	
	public void wrongNr() {JOptionPane.showMessageDialog(null, "Pracownik o podanym numerze nie istnieje", "Nieprawid�owy numer", JOptionPane.WARNING_MESSAGE);}
	
	public void number2() {JOptionPane.showMessageDialog(null, "Pola kategorii \"Sta� Pracy\" i \"Pensja\" musz� by� uzupe�nione warto�c� liczbow�", "Wymagana warto�� liczbowa!!", JOptionPane.WARNING_MESSAGE);}
	
}
