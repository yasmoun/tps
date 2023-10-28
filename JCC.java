import java.util.Scanner;
class Film{
	protected String titre;
	protected String realisateur;
	protected String pays_origine;
	protected int duree;
	protected int nbPlace;
	int nbEtudiant;
	int nbPublic;
	Film (String titre, String r, String pays, int d){
		this.titre=titre;
		this.realisateur=r;
		this.pays_origine=pays;
		this.duree=d;
	}
	void setNbPlace(int nb) {
		this.nbPlace=nb;
	}
	int getNbPlace() {
		return this.nbPlace;
	}
	String getTitre() {
		return this.titre;
	}
	String getRealisateur() {
		return this.realisateur;
	}
	String getPays() {
		return this.pays_origine;
	}
	int getDuree() {
		return this.duree;
	}
	public String toString() {
		return this.getClass().getSimpleName()+" : "+this.getTitre()+" de "+this.realisateur+" ("+this.pays_origine+") - "+this.duree+"min";
	}
	void ventebillets() {
		Scanner sc =new Scanner(System.in);
		do {
		System.out.print("donner le nombre des places pour etudiants pour le "+this.getClass().getSimpleName()+" du titre "+this.getTitre()+" : ");
		nbEtudiant=sc.nextInt();}
		while(!(nbEtudiant<=nbPlace));
		nbPublic =nbPlace-nbEtudiant;		
	}
	float totalVenteBillets () {
		ventebillets();
		return 2*nbEtudiant+3*nbPublic;
	}
}
class Documentaire extends Film{
	private String sujet;
	private final int tarif=2;
	Documentaire(String titre, String r, String pays, int d,String sujet){
		super(titre,r,pays,d);
		this.sujet=sujet;
	}
	String getSujet() {
		return this.sujet;
	}
	public String toString() {
		return super.toString()+"\n \t il parle de "+this.getSujet();
	}
	float totalVenteBillets () {
		super.ventebillets();
		return tarif*super.getNbPlace();
	}
}
class JCC {
	Film competition[];
	int annee;
	final int NBFMAX=30;
	int nbF=0;
	int taille;
	JCC(int annee,int taille){
		this.annee=annee;
		if(taille < NBFMAX)
			this.taille=taille;
		else
			System.out.println("taille invalide");
		competition =new Film[NBFMAX];
	}
	void ajoutFilm (Film f) {
		if(nbF<taille) {
			competition[nbF]=f;
			nbF++;}
		else
			System.out.println("La compétition est complete");
	}
	void listeFilmsJCC () {
		for(int i=0;i<competition.length;i++) {
			if(competition[i]!=null)
				System.out.println(competition[i].toString());
		}
	}
	int totalVenteBilletsJCC () {
		int montant=0;
		for(int i=0;i<competition.length;i++) {
			if(competition[i]!=null)
				montant+=competition[i].totalVenteBillets();
		}
		return montant;
	}
}
class Test{
	public static void main(String[] args) {
		JCC jcc=new JCC(2021,2);
		Documentaire d=new Documentaire("Le dernier refuge","Ousman","Mali",86,"La guerre civile");
		d.setNbPlace(30);
		Film f=new Film ("Insurrection","Jilani Saadi","Tunisie",105);
		f.setNbPlace(45);
		jcc.ajoutFilm(d);
		jcc.ajoutFilm(f);
		jcc.listeFilmsJCC();
		System.out.println("le montant des ventes de billets pour le JCC = "+jcc.totalVenteBilletsJCC()+"Dt");
	}
}
