class Vetement{
	protected String lib;
	protected float pht;
	protected String code;
	protected String c;
	protected int quantite;
	protected final int TVA=18;
	Vetement (String lib, float pht, String code, String c){
		this.lib=lib;
		this.pht=pht;
		this.code=code;
		this.c=c;
	}
	void setQuantite(int q) {
		this.quantite=q;
	}
	int getQuantite() {
		return this.quantite;
	}
	String getLibelle() {
		return this.lib;
	}
	float getPht() {
		return this.pht;
	}
	String getCode() {
		return this.code;
	}
	String getCouleur() {
		return this.c;
	}
	public String toString() {
		return this.getClass().getSimpleName()+" -> "+this.getCode()+" "+this.getLibelle()+" "+this.getCouleur()+" "+" : prixHT= "+this.getPht()+" DT et qte= "+this.getQuantite();
	}
	float prixTTC() {
		return this.getPht()*(1+TVA/100f);
	}
	float prixTTC (int remise) {
		return  prixTTC()*(1-remise/100f);
	}
}
class VetementEnfant extends Vetement{
	private float age ;
	VetementEnfant(String lib, float pht, String code, String c, float age){
		super(lib,pht,code,c);
		setAge(age);
	}
	void setAge (float age) {
		if(age>0)
			this.age=age;
		else
			System.out.println("age invalide");
	}
	float getAge() {
		return this.age;
	}
	public String toString() {
		return super.toString()+" , age = "+this.getAge();
	}
	@Override
	float prixTTC (int remise) {
		if(remise <50) {
			return super.prixTTC(remise);}
		else {
			return super.prixTTC();}
	}
}

public class Boutique {
Vetement tabVet[];
String nom;
int taille;
int nbVet=0;
Boutique (String n, int taille){
	this.nom=n;
	this.taille=taille;
	tabVet=new Vetement[taille];
}
void ajoutVetement (Vetement v) {
	if(nbVet<taille) {
		tabVet[nbVet]=v;
		nbVet++;}
	else {
		System.out.println("Boutique pleine");
	}		
}
void afficheStock (int remise) {
	for(int i=0;i<tabVet.length;i++) {
		if(tabVet[i] != null) {
		if(tabVet[i].getQuantite()>0) {
			System.out.println(tabVet[i].toString());
			System.out.println("prix avant remise : ");
			System.out.println("\t prix TTC :"+tabVet[i].prixTTC());
			System.out.println("prix apres remise : ");
			System.out.println("\t prix TTC :"+tabVet[i].prixTTC(remise));
		}}
	}
}
}
class Test{
	public static void main(String[] args) {
		Boutique b= new Boutique("HA",50);
		Vetement v1= new VetementEnfant("Robe",29.900f,"R100","rouge",0.5f);
		v1.setQuantite(10);
		Vetement v2=new Vetement("Manteau",169.900f,"M200","gris");
		v2.setQuantite(5);
		b.ajoutVetement(v1);
		b.ajoutVetement(v2);
		System.out.println("les articles disponibles : ");
		b.afficheStock(60);
		v2.setQuantite(v2.getQuantite()-5);
		System.out.println("les articles disponibles : ");
		b.afficheStock(60);
	}
}
