class Vehicule {
private int num;
private String marque;
private String modele;
private int annee;
private double prix;
static int count=0;
Vehicule(String marque, String modele, int annee, double prix){
	this.num=++count;
	this.marque=marque;
	this.modele=modele;
	this.annee=annee;
	this.prix=prix;
}
@Override
public String toString() {
	return "Vehicule n°"+num+": marque :"+this.getMarque()+", modele :"+this.getModele()+", annee :"+this.getAnnee()+", prix :"+this.getPrix();
}
void decrisVehicule(){
	System.out.println(toString());
}
void SetMarque(String mar) {
	this.marque=mar;
}
String getMarque() {
	return this.marque;
}
void SetModele(String mod) {
	this.modele=mod;
}
String getModele() {
	return this.modele;
}
void SetPrix(double p) {
	this.prix=p;
}
double getPrix() {
	return this.prix;
}
int getCount() {
	return count;
}
int getAnnee() {
	return this.annee;
}
}
class AgenceMobiliere{
	private Vehicule[] tab;
	int max;
	int nb;
	AgenceMobiliere(int max){
		 	this.max = max;
	        this.tab = new Vehicule[max];
	        this.nb = 0;
	}
	void ajoutVehicule(Vehicule v) {
		if(nb<max) {
			tab[nb] = v;
            nb++;
		}
		else
			System.out.println("Pas de place,le tableau est complet !");
	}
	void selection(int n) {
		if (n<nb && n>=0) {
			if(tab[n]!=null){
				tab[n].decrisVehicule();
			}
		}
		else {
			System.out.println("erreur !");
		}
	}
	void selection(String mq) {
		boolean found=false;
		for(int i=0;i<this.nb;i++) {
			if(tab[i].getMarque().equals(mq)){
				tab[i].decrisVehicule();
				found=true;
			}
		}
		if(!found) {
			System.out.println("il n’y a pas de véhicules de cette marque");
		}
	}
	void selection(double px) {
		boolean found=false;
		for(int i=0;i<this.nb;i++) {
			if(tab[i].getPrix()<px){
				tab[i].decrisVehicule();
				found=true;
			}
        if(!found) {
        	System.out.println("il n’y a pas de véhicules dans cette marge de prix");
        }
        	
	}
}
	void affiche() {
		for(int i=0;i<this.nb;i++) {
			tab[i].decrisVehicule();
		}
	}
void Ancienne() {
		int min=tab[0].getAnnee();
		int imin=0;
		for(int i=0;i<this.nb;i++) {
			if(tab[i].getAnnee()<min) {
				min=tab[i].getAnnee();
				imin=i;
				}
		}
		System.out.println("la voiture avec l'annee la plus ancienne:");
		tab[imin].decrisVehicule();
	}
}
class test{
	public static void main(String[] args) {
		Vehicule v=new Vehicule("Clio","Classique",2000,20.000);
		Vehicule w=new Vehicule("Mercedes","Fantôme",2008,60.000);
		Vehicule x=new Vehicule("KIA","Picanto",2012,35.000);
		AgenceMobiliere agence = new AgenceMobiliere(3);
        agence.ajoutVehicule(v);
        agence.ajoutVehicule(w);
        agence.ajoutVehicule(x);
        agence.affiche();
        agence.selection("Mercedes");
        agence.selection( 40.000);
        agence.selection(2);
        agence.Ancienne();
	}
}
