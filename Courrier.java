public class Courrier {
	protected boolean mode_expedition;
	protected String adresse_dest;
	protected final double tarif=0.5;
	Courrier(boolean mode_expedition, String adresse_dest){
		this.mode_expedition=mode_expedition;
		this.adresse_dest=adresse_dest;
	}
	void setAdresse(String adresse){
		this.adresse_dest=adresse;
	}
	String getAdresse(){
		return this.adresse_dest;
	}
	void setMode(String mode) {
		if (mode.equalsIgnoreCase("express"))
			this.mode_expedition=true;
		else if (mode.equalsIgnoreCase("normal"))
			this.mode_expedition=false;
		else
			System.out.println("mode invalide choisit entre normal et express !");
			
	}
	boolean getMode() {
		return this.mode_expedition;
	}
	 boolean estValide(){
		 if(getAdresse().length()==0)
			 return false;
		 else
			 return true;
	 }
	 public String toString() {
		 return this.getClass().getSimpleName()+": mode expedition -> "+getMode()+" adresse -> "+getAdresse()+" tarif -> "+affranchir();
	 }
	 void decrire() {
		 System.out.println(toString());
		 
	 }
	 double affranchir() {
		 if(estValide()) {
		 if(getMode())
			return tarif*2;
		 else 
			 return tarif;}
		 else 
			 return 0;
	 }
}
class Lettre extends Courrier{
	private double poids;
	private String format ;
	Lettre(boolean mode_expedition, String adresse_dest,double poids,String format){
		super(mode_expedition, adresse_dest);
		this.poids=poids;
		if ("A3".equalsIgnoreCase(format) || "A4".equalsIgnoreCase(format)) {
            this.format = format.toUpperCase();}
		else
			System.out.println("format invalide");
	}
	void setPoids(double p) {
		this.poids=p;
	}
	double getPoids() {
		return this.poids;
	}
	void Setformat(String f) {
		 this.format=f;}
	String getFormat() {
		return this.format;
	}
	void decrire() {
		super.decrire();
		System.out.println("\t poids -> "+this.getPoids()+" ,format -> "+this.getFormat());
	}
	double affranchir() {
		double montant=0;
		if(super.estValide()) {
		    montant=0.5*this.getPoids()*0.001;
			if(this.getFormat().toUpperCase().equals("A4")) 
				montant+=2.5;
			else
				montant+=3.5; 
			if(super.getMode())
				montant*=2; }
		return montant;
		
	}
}
class Colis extends Courrier{
	private double poids;
	private double volume;
	Colis(boolean mode_expedition, String adresse_dest,double poids,double volume){
		super(mode_expedition, adresse_dest);
		this.poids=poids;
		this.volume=volume;
	}
	double getPoids() {
		return this.poids;
	}
	double getVolume() {
		return this.volume;
	}
	void decrire() {
		super.decrire();
		System.out.println(" \t poids -> "+this.getPoids()+" ,volume -> "+this.getVolume());
	}
	double affranchir() {
		return 0.25*this.getVolume()+this.getPoids()*0.001;
	}
}
class BoiteCourrier {
	Courrier tab[];
	int n;
	int nb=0;
	BoiteCourrier(int n){
		this.n=n;
		tab=new Courrier[n];
	}
	void ajouter(Courrier c) {
		if(nb<n) {
			tab[nb]=c ;
			nb++;
		}
	}
	double affranchir() {
		double montant=0;
		for(int i=0;i<nb;i++) {
				montant+=tab[i].affranchir();
		}
		return montant;
	}
	int courriersInvalides(){
		int nb_invalide=0;
		for(int i=0;i<nb;i++) {
			if(!(tab[i].estValide()))
				nb_invalide++;}	
		return nb_invalide;
	}
	void afficher() {
		for(int i=0;i<nb;i++) {
			tab[i].decrire();
			if(!(tab[i].estValide()))
				System.out.println(" Courrier invalide");
		}
	}
}
class test{
	public static void main(String[] args) {
		BoiteCourrier c=new BoiteCourrier(4);
		Courrier c1=new Courrier(true, "xxxxx");
		Courrier c2=new Lettre(false, "",14.5,"a3");
		Courrier c3=new Colis(true, "wwww",23,12);
		Courrier c4=new Courrier(false, "");
		c.ajouter(c1);
		c.ajouter(c2);
		c.ajouter(c3);
		c.ajouter(c4);
		c.afficher();
		c1.setMode("Normal");
		c.afficher();
		System.out.println("le nombre de courrier invalide = "+c.courriersInvalides());
		System.out.println("le montant total = "+c.affranchir());
	}
	
	
}