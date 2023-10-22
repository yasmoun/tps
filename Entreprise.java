class Salarie{
	protected int Matricule;
	protected String Nom;
	protected double Recrutement;
	Salarie(int Matricule , String Nom , double Recrutement){
		this.Matricule=Matricule;
		this.Nom=Nom;
		this.Recrutement=Recrutement;
	}
	void SetMatricule(int m) {
		this.Matricule=m;
	}
	int getMatricule() {
		return this.Matricule;
	}
	void SetNom(String n) {
		this.Nom=n;
	}
	String getNom() {
		return this.Nom;
	}
	void SetRecrutement(double r) {
		this.Recrutement=r;
	}
	double getRecrutement() {
		return this.Recrutement;
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+": nom -> "+this.getNom()+", matricule -> "+this.getMatricule()+", recrutement :"+this.getRecrutement();
	}
	void affiche() {
		System.out.println(toString());
	}
	double Salaire() {
		if(this.Recrutement<2005)
			return 400;
		else
			return 280;
	}
}
class Employe extends Salarie{
	private double Hsupp;
	private double PHsupp;
	Employe(int Matricule , String Nom , double Recrutement,double Hsupp, double PHsupp){
		super(Matricule,Nom,Recrutement);
		this.Hsupp=Hsupp;
		this.PHsupp=PHsupp;
	}
	void SetHsupp(double Hs) {
		this.Hsupp=Hs;
	}
	double getHsupp() {
		return this.Hsupp;
	}
	void SetPHsupp(double PH) {
		this.Hsupp=PH;
	}
	double getPHsupp() {
		return this.PHsupp;
	}
	    public void affiche() {
	        super.affiche();
	        System.out.println("Heures supp : " + Hsupp+" , Prix des heures supp : " + PHsupp);
	    }
	  @Override
	 double Salaire() {
		 double s=super.Salaire();
		 s+=(this.Hsupp * this.PHsupp);
		 return s;
	 }
}
class Vendeur extends Salarie{
	private double Vente;
	private double Pourcentage;
	Vendeur(int Matricule , String Nom , double Recrutement,double Vente,double Pourcentage){
		super(Matricule,Nom,Recrutement);
		this.Vente=Vente;
		this.Pourcentage=Pourcentage;
	}
	void SetVente(double v) {
		this.Vente=v;
	}
	double getVente() {
		return this.Vente;
	}
	void SetPourcentage(double p) {
		this.Pourcentage=p;
	}
	double getPourcentage() {
		return this.Pourcentage;
	}
	@Override 
	void affiche(){
		super.affiche();
		System.out.println("vente :"+this.getVente()+", Pourcentage :"+this.getPourcentage());
	}
	double Salaire() {
		 double s=super.Salaire();
		 s+=(this.Vente * this.Pourcentage);
		 return s;
	 }
}
//this.getClass().getSimpleName()
/* Salarie s=new Salarie();
 			=new Emplye();
 			=new Vendeur();
 */
public class Entreprise {
	public static void main(String[] args) {
		/*Salarie s=new Salarie(123,"yasmine",2012);
		Employe e=new Employe(158,"douaa",2005,12,10);
		s.affiche();
		System.out.println("salire :"+s.Salaire());
		e.affiche();
		System.out.println("salire :"+e.Salaire());
		Vendeur v=new Vendeur(179,"maya",2002,50,25);
		v.affiche();*/
		Salarie tabSalarie[]=new Salarie[5];
		tabSalarie[0]=new Employe(12345,"Walid",2002,15,4);
		tabSalarie[1]=new Vendeur(23445,"Yessine",2007,1000,0.1);
		tabSalarie[2]=new Vendeur(65478,"Nassime",2000,700,0.1);
		tabSalarie[3]=new Employe(87698,"Aymen ",2003,19,5); 
		tabSalarie[4]=new Employe(12345,"Khaled",2008,7,4);
		System.out.println("**** Liste des Emplyees ****");
		for(int i=0;i<tabSalarie.length;i++) {
			if(tabSalarie[i] instanceof Employe)
				tabSalarie[i].affiche();
		}
		System.out.println("**** Liste des Vendeurs ****");
		for(int i=0;i<tabSalarie.length;i++) {
			if(tabSalarie[i] instanceof Vendeur)
				tabSalarie[i].affiche();
		}
		System.out.println("****  Nom du salarie le plus ancien dans l'entreprise ****");
		Salarie a= tabSalarie[0];
		for(int i=0;i<tabSalarie.length;i++) {
			if(a.getRecrutement()>tabSalarie[i].getRecrutement()) {
				a=tabSalarie[i];
			}
		}
		System.out.println("nom :"+a.getNom()+" recrute en l'an "+a.getRecrutement());
		System.out.println("****  Matricule du vendeur disposant du plus grand salaire ****");
		Salarie s= null;
		for(int i=0;i<tabSalarie.length;i++) {
			if(tabSalarie[i] instanceof Vendeur) {
				if(s==null) {
					s= tabSalarie[i];
				}
			else if(s.Salaire()< tabSalarie[i].Salaire()) {
				s=tabSalarie[i];
		     }
			}
		}
		System.out.println("Matricule ="+s.getMatricule()+" de salaire ="+s.Salaire()+" Dt");
	}
}