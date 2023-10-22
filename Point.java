class Point {
		 protected char nom;
		 protected int abs;
		 protected int ord;
	Point(){}
	Point(char nom,int abs,int ord){
		this.nom=nom;
		this.abs=abs;
		this.ord=ord;
	}
	Point(Point p){
		nom=p.nom;
		abs=p.abs;
		ord=p.ord;
	}
	@Override
	public String toString() {
		return nom+"("+abs+","+ord+")";
	}
	void affiche() {
		System.out.println(toString());
	}
	void deplacer(int ab, int or) {
		abs+=ab;
		ord+=or;
	}
	void resetPoint() {
		abs=0;
		ord=0;
	}
	 boolean coincide_V1(Point p) {
		return ((this.abs==p.abs)&&(this.ord==p.ord));
	}
	static boolean coincide_V2(Point p1, Point p2) {
	    return (p1.abs == p2.abs) && (p1.ord == p2.ord);
	}
}
class PointCol extends Point{
		private String couleur;
		PointCol(){};
		PointCol(char nom,int abs,int ord,String couleur){
			super(nom, abs, ord);
			this.couleur=couleur;
		}
		void setCouleur(String c) {
			this.couleur=c;
		}
		String getCouleur() {
			return this.couleur;
		}
		@Override
		void affiche() {
			super.affiche();
			System.out.println("couleur : "+this.getCouleur());
		}
	}
 class test {
	public static void main(String[] args) {
		PointCol p=new PointCol('A',1,2,"rouge");
		p.affiche();
		p.setCouleur("bleu");
		p.affiche();
		//Point p2 = new Point('B', 3, 4);
		Point p3=p;
		p3.affiche();
	}

}
