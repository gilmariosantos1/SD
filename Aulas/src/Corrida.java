import java.util.ArrayList;


public class Corrida {

	public static int tamCircuito = 1000;
	public static int maxPulo = 10;
	public static int classificacao = 0;
	
	
	public static void main(String[] args) {

		
		Sapo s1 = new Sapo("s1");
		Sapo s2 = new Sapo("s2");
		Sapo s3 = new Sapo("s3");
		Sapo s4 = new Sapo("s4");
		Sapo s5 = new Sapo("s5");
		
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s5.start();
		
		
		
	}		

}
