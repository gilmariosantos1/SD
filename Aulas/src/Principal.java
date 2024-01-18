import java.util.Random;


public class Principal {

	
	public static void main(String args[]){
		
		int[][] m1 = new int[3][5];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				m1[i][j] = new Random().nextInt(9);
				System.out.print(m1[i][j]+" ");
			}
			System.out.println("");		
		}
		
			
		SomaLinha t1 = new SomaLinha(m1, 0);
		SomaLinha t2 = new SomaLinha(m1, 1);
		SomaLinha t3 = new SomaLinha(m1, 2);
		t1.start();
		t2.start();
		t3.start();
	
			
			
	}
	
}
