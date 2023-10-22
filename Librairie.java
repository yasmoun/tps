class Livre{
	protected String titre;
	protected int identifiant;
	final double TVA=0.1;
	protected String domaine;
	protected int nb_pages;
	Livre(String titre,int identifiant,String domaine,int nb_pages){
		this.titre=titre;
		this.identifiant=identifiant;
		this.domaine=domaine;
		this.nb_pages=nb_pages;
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+": titre -> "+this.getTitre()+", identifiant -> "+this.getIdentifiant()+", domaine -> "+this.getDomaine()+", nombre de pages -> "+this.getNbPages();
	}
	void afficher() {
		System.out.println(toString());
	}
	String getTitre() {
		return this.titre;
	}
	int getIdentifiant() {
		return this.identifiant;
	}
	String getDomaine() {
		return this.domaine;
	}
	int getNbPages() {
		return this.nb_pages;
	}
	double calculePrix() {
		return (0.075 * this.getNbPages())*(1+TVA);
	}
	
}
class Roman extends Livre{
	private  String auteur;
	private String editeur;
	Roman(String titre,int identifiant,String domaine,int nb_pages, String auteur, String editeur){
		super(titre, identifiant, domaine,nb_pages);
		this.auteur=auteur;
		this.editeur=editeur;
	}
	String getAuteur() {
		return this.auteur;
	}
	String getEditeur() {
		return this.editeur;
	}
	@Override
	double calculePrix() {
		return (0.05 * this.getNbPages())*(1+TVA);
	}
	@Override
	void afficher() {
		super.afficher();
		System.out.println("auteur -> "+this.getAuteur()+", editeur -> "+this.getEditeur());
	}
}
class Magazine extends Livre{
	private int mois_parution;
	Magazine(String titre,int identifiant,String domaine,int nb_pages,int mois_parution){
		super(titre, identifiant, domaine,nb_pages);
		this.mois_parution=mois_parution;
	}
	int getMoisParution() {
		return this.mois_parution;
	}
	double calculePrix(int bonus) {
		return (0.35 * this.getNbPages())*(1+TVA)+bonus;
	}
	@Override
	void afficher() {
		super.afficher();
		System.out.println("mois de parution -> "+this.getMoisParution());
	}
}
class Librairie {
	Livre librairie[];
	private int capacite;
	private int nb;
	Librairie(int capacite) {
		this.capacite=capacite;
		librairie =new Livre[capacite];
		nb=0;
	}
	int getNb() {
		return this.nb;
	}
	int getCapacite() {
		return this.capacite;
	}
	void inventaire() {
		for(int i=0;i<nb;i++) {
			librairie[i].afficher();
			if(librairie[i] instanceof Magazine) {
			Magazine magazine = (Magazine) librairie[i];	
			System.out.println("prix = "+magazine.calculePrix(10));}
			else if(librairie[i] instanceof Roman) {
				Roman roman = (Roman) librairie[i];
				System.out.println("prix = "+roman.calculePrix());
			}
			else {
				System.out.println("prix = "+librairie[i].calculePrix());
		}
	}
	}
	void inventaire(String categ) {
		for(int i=0;i<nb;i++) {
			if(librairie[i].getDomaine().equals(categ)) {
				librairie[i].afficher();
				if(librairie[i] instanceof Magazine) {
					Magazine magazine=(Magazine) librairie[i];
				System.out.println("prix = "+magazine.calculePrix(10));}
				else {
					System.out.println("prix = "+librairie[i].calculePrix());
				}
			}
		}
	}
	void ajoutLiv(Livre liv) {
		if(nb<capacite) {
			librairie[nb]=liv;
			nb++;
		}
		else {
			System.out.println("impossible d'ajouter");
		}
	}
	void suppLiv(int num) {
		boolean trouve = false;
		for(int i=0;i<nb;i++) {
			if(librairie[i].getIdentifiant()==num) {
				librairie[i]=null;
				trouve=true;
				nb--;
				break;
			}
		}
		if(!trouve) {
			System.out.println("livre introuvable");
		}
	}
	double montant_totale(){
		double montant=0;
		for(int i=0;i<nb;i++) {
		if(librairie[i] instanceof Magazine) {
			Magazine magazine=(Magazine) librairie[i];
			montant+=magazine.calculePrix(10);
			}
		else if (librairie[i] instanceof Roman) {
			Roman roman=(Roman) librairie[i];
			montant+=roman.calculePrix();
			}
		else {
			montant+=librairie[i].calculePrix();
	}
		
}
		return montant;
}
class test {
	public static void main(String[] args) {
		Librairie librairie=new Librairie(4);
		Livre l=new Livre("le chien jaune",21,"cartoon",221);
		Roman r=new Roman("les miserables",45,"drama",514,"Victor Hugo","xxxx");
		Magazine m=new Magazine("voyage au bout de la nuit",78,"imaginaire",617,12);
		librairie.ajoutLiv(l);
		librairie.ajoutLiv(r);
		librairie.ajoutLiv(m);
		librairie.inventaire();
		Livre l2=new Roman("le lion",21,"cartoon",221,"Joseph","WWWW");
		librairie.ajoutLiv(l2);
		librairie.inventaire();
		System.out.println("liste des cartoon :");
		librairie.inventaire("cartoon");
		double montantTot=librairie.montant_totale();
		System.out.println("le montant total du client ="+montantTot);
		}
	}
}
