//test 

public class StudRec {
	public static void main(String[] args) {
		Student iskulmateko = new Student();
		Student iskulmateniya = new Student();
		
		int i = iskulmateniya.fetchschoolcode();
		System.out.println("SC ni iskutmateniya: " + i);
		
		iskulmateniya.changeschoolcode(14344);
		
		int j = iskulmateko.fetchschoolcode();
		System.out.println("SC ni iskulmateko: " + j);
	}
}
