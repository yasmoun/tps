import java.util.Scanner;

public class Tab {
    static final int NMAX = 40;
    public static void remplir(float t[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < t.length; i++) {
        do {
            System.out.print("Donner la valeur n"+(i+1)+": ");
            float v = sc.nextFloat();
            t[i] = v;}
        while(!(t[i]>=0 && t[i]<=20));
        }}
    public static void lister(float t[]) {
        for (int i = 0; i <t.length ; i++) {
            System.out.println("t[" + (i+1) + "] = " + t[i]);
        }
    }
    static float somme_element(float t[]){
    	float s=0;
    	for (int i = 0; i <t.length; i++) {
    		s+=t[i];
    	}
    	return s;
    }
  public static float[] additionner (float t1[], float t2[]) {
	   float t3[] = new float[t1.length];
	   for(int i = 0; i <t1.length ; i++) {
		   t3[i] = t1[i] + t2[i];}
	   return t3;
   }
   static float[] produit (float x, float t[]) {
	   for(int i = 0; i <t.length ; i++) {
		   t[i] = t[i]*x ;}
	   return t;
   }
   static float[] division (float x, float t[]) {
	   for(int i = 0; i <t.length ; i++) {
		   t[i] = t[i]/x ;}
	   return t;
   }
   static float[] additionner(float x, float t[]) {
	   for(int i=0;i<t.length;i++) {
		   t[i]+=x;
		   if(t[i]>20) {
			   t[i]=20;
		   }
	   }
	   return t;
   }
}
   class CalculMoyenne{
	   public static void main(String[] args) {
		   Scanner sc =new Scanner(System.in);
		   int nb;
		   	do{
		   		System.out.print("enter la taille des tableaux : ");
		   		 nb=sc.nextInt();
		   	}
	    	while(!(nb>0 && nb<Tab.NMAX));
		   	System.out.println("remplissage du tableau Ctrl : ");
	    	float noteCtrl[] = new float[nb];
	    	Tab.remplir(noteCtrl); 
	    	System.out.println("remplissage du tableau Exam : ");
	    	float noteExam[] = new float[nb];
	        Tab.remplir(noteExam);
	        System.out.println("affichage du tableau Ctrl : ");
	        Tab.lister(noteCtrl); 
	        System.out.println("affichage du tableau Exam : ");
	        Tab.lister(noteExam); 
	        System.out.println("affichage du tableau Exam avec bonus : ");
	        Tab.lister(Tab.additionner(1.5f,noteExam ));
	        float moy[] = new float[nb];
	        if(noteCtrl.length!=noteExam.length) {
	        	System.out.println("les deux tableaux ne sont pas egaux");
	        }
	        else {
	        	System.out.println("affichage du moyenne des etudiant : ");
		        moy=Tab.division (3,Tab.additionner (noteCtrl,Tab.produit (2,noteExam))); 
		        Tab.lister(moy);
		        System.out.println("affichage du moyenne la classe : ");
		        System.out.println(Tab.somme_element(moy)/nb);
	        }        
   }
}
   /* public static void main(String[] args) {
    	Scanner sc =new Scanner(System.in);
    	System.out.print("enter la taille du tableau 1 : ");
    	int n=sc.nextInt();
    	float tableau1[] = new float[n];
    	Tab.remplir(tableau1); 
    	System.out.print("enter la taille du tableau 2 : ");
    	int m=sc.nextInt();
    	float tableau2[] = new float[m];
        Tab.remplir(tableau2); 
        Tab.lister(tableau1);
        Tab.lister(tableau2);
        System.out.println(Tab.somme_element(tableau1));
        System.out.println(Tab.somme_element(tableau2));
        Tab.lister(additionner (tableau1, tableau2));
        Tab.lister( produit (2,tableau1));
    }
}*/