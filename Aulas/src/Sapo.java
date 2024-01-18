import java.util.Random;


public class Sapo extends Thread{
	private String nome;
	private int colocacao;
	
	public Sapo(String nome){
		this.nome = nome;
	}
	
	
	public void run(){
		int percorreu = 0;
		
		while(percorreu < Corrida.tamCircuito){
			percorreu = percorreu + new Random().nextInt(Corrida.maxPulo);
			
		}
		
		synchronized (this) {
			Corrida.classificacao++;
			colocacao = Corrida.classificacao;
		}
		System.out.println(nome+" "+colocacao);

		
	}
	

}
