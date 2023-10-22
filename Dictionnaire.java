class MotDico {
private int num;
static int count=0;
private String mot;
private String definition;
MotDico(String mot, String definition) {
    this.num =++count;
    this.mot = mot;
    this.definition = definition;
}
String getMot () {
	return this.mot;
}
String getDefinition () {
	return this.definition;
}
void setDefintion (String s) {
	this.definition=s;
}
void setMot (String s) {
	this.mot=s;
}
int getNum () {
	return this.num;
}
 boolean synonyme (MotDico m) {
	 return m.getDefinition().equalsIgnoreCase(this.getDefinition());}
}
class Dictionnaire{
	private int nbMots;
	private MotDico[] dico;
	private String nom;
	Dictionnaire(String nom,int nbMots){
		this.dico = new MotDico[nbMots];
		this.nom=nom;
		}
	String getNom () {
		return this.nom;
	}
	 void ajouterMot (MotDico m) {
		dico[nbMots] = m;
		nbMots++;
	}
	 MotDico getMot(int i) {
		 return dico[i];
	 }

	 int chercherMot (String ch) {
		int trouve=-1;
		int i=0;
		do {
			if(ch.equals(dico[i].getMot())){
				trouve=i;
			}
			else {
				i++;
			}
		}while(i<nbMots && trouve ==-1);
		return trouve;
	}
	void supprimerMot (String ch) {
		if(chercherMot (ch)!=-1) {
		 for (int i = chercherMot (ch) ; i < nbMots-1; i++) {
	            dico[i] = dico[i + 1];
	}
		nbMots--;
	}
		else {
			System.out.println(" mot introuvable ");
		}
		}
	 void listerDico () {
		System.out.println("dictionnaire("+getNom()+") : ");
		for(int i=0;i<nbMots;i++) {
		System.out.println("Mot n"+dico[i].getNum()+":"+dico[i].getMot()+" -> "+ dico[i].getDefinition()+"\n");
		}
	}
	 void listerDico (int i) {
			System.out.println("dictionnaire("+getNom()+") : ");
			System.out.println("Mot n"+dico[i].getNum()+":"+dico[i].getMot()+" -> "+ dico[i].getDefinition()+"\n");
		}
	 int nbSynonymes (MotDico m) {
		 int nb = 0;
	        for (int i = 0; i < nbMots; i++) {
	            if (dico[i].synonyme(m)) {
	                nb++;
	            }
	        }
	        return nb;
	    }
	 }
class test{
	public static void main(String[] args) {
		Dictionnaire dc = new Dictionnaire("Larousse",3);
		MotDico mot1 = new MotDico("arbre", "une plante ligneuse terrestre comportant un tronc");
		MotDico mot2 = new MotDico("miroir", "verre ou surface polie et metallisee qui reflechit la lumiere");
		MotDico mot3 = new MotDico("ravissante", "un adjectif qui signifie extremement jolie, charmante");
		dc.ajouterMot(mot1);
	    dc.ajouterMot(mot2);
	    dc.ajouterMot(mot3);
	    dc.listerDico();
	    if (dc.chercherMot ("belle")  != -1) {
	    	dc.listerDico (dc.chercherMot ("belle"));
	    } else {
	        System.out.println("Le mot n'existe pas dans le dictionnaire.");
	    }
	    if (dc.chercherMot ("arbre")  != -1) {
	    	dc.listerDico (dc.chercherMot ("arbre"));
	    } else {
	        System.out.println("Le mot n'existe pas dans le dictionnaire.");
	    }
	    if (dc.chercherMot ("arbre") != -1) {
	        int nb = dc.nbSynonymes(dc.getMot(dc.chercherMot ("arbre")));
	        System.out.println("Le mot a " + nb + " synonyme.");
	        dc.supprimerMot("arbre");
	}
	    else {
	    	System.out.println("le mot n'existe pas ");
	    }
	    dc.listerDico();
}
}
