package projekt1;

public class Person {
	private static int i=1;
	private final int lp;
	private String imie;
	private String nazwisko;
	private String stanowisko;
	private int stazPracy;
	private int pensja;
	
	public Person(String imie, String nazwisko, String stanowisko, int stazPracy, int pensja) {
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.stanowisko=stanowisko;
		this.stazPracy=stazPracy;
		this.pensja=pensja;
		lp=i;
		i++;
	}

	public String getStanowisko() {	return stanowisko;}

	public void setStanowisko(String stanowisko) {this.stanowisko = stanowisko;}

	public static int getI() {return i;}

	public static void setI(int i) {Person.i = i;}

	public int getLp() {return lp;}

	public String getImie() {return imie;}

	public void setImie(String imie) {this.imie = imie;}

	public String getNazwisko() {return nazwisko;}

	public void setNazwisko(String nazwisko) {this.nazwisko = nazwisko;}

	public int getStazPracy() {return stazPracy;}

	public void setStazPracy(int stazPracy) {this.stazPracy = stazPracy;}

	public int getPensja() {return pensja;}

	public void setPensja(int pensja) {this.pensja = pensja;}
}