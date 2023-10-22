package iset.dsi2.animalerie;

public class Animal {
	protected String couleur;
	protected int poids=20;
	Animal(){}
	Animal(String couleur, int poids){
	this.couleur= couleur;
	this.poids=poids;
	}
	public void boire(){
	System.out.println("je bois de l'eau");
	}
	public void manger(){
	System.out.println(" je mange de la nourriture");
	}
	public void crier(){
	System.out.println(" Je crie ");
	}
	public String toString() {
	return (" Je suis un objet de " +this.getClass().getSimpleName()+", je suis de couleur "+ this.couleur +" et je pese " + this.poids+" kg "); }
	public void decrisToi(){
	System.out.println(this.toString());
	}
	}

class Chat extends Animal{
	private boolean sauvage;
	Chat(){}
	Chat(String couleur, int poids, boolean sauvage){
		super(couleur,poids);
		this.sauvage=sauvage;
	}
	boolean getSauvage() {
		return this.sauvage;
	}
}
class Chien extends Animal{
	private String race ;
	Chien(){}
	Chien(String couleur, int poids, String race){
		super(couleur,poids);
		this.race=race;;
	}
	String getRace() {
		return this.race;
	}
}
class TestHeritage {
	public static void main(String[] args) {
		Animal [] a=new Animal[3];
		a[0]= new Animal("gris",2);
		a[1]=new Chat("black",25,true);
		a[2]=new Chien("brown",75,"bichon");
		for(int i=0;i<a.length;i++) {
			a[i].decrisToi();
			a[i].manger();
			a[i].boire();
			a[i].crier();
			if(a[i].getClass() == Animal.class) {
				System.out.println("L’espece de cet animal est inconnue");
			}
		}
}
}
