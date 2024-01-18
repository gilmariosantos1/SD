import java.io.*;
import java.net.*;


public class cliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
		//	List<String> list = 
			//           Collections.synchronizedList(new ArrayList<String>()); 
			  

//			Socket clientSocket = new Socket(endereco[0], Integer
//					.parseInt(endereco[1]));
			System.out.println("teste 1");
			Socket clientSocket = new Socket("localhost", 8001);
			System.out.println("teste 2");

			DataOutputStream outToServer =
					new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes("teste.txt" + '\n');

			
			// Criando arquivo que sera recebido pelo servidor
			FileOutputStream fileOut = new FileOutputStream("cliente_teste.txt");

			// Criando canal de transferencia
			InputStream socketIn = clientSocket.getInputStream();

			// Lendo o arquivo recebido pelo socket e gravando no
			// arquivo local
			System.out.println("Recebendo Arquivo: cliente_teste.txt");

			byte[] cbuffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = socketIn.read(cbuffer)) != -1) {
				fileOut.write(cbuffer, 0, bytesRead);
			}
			fileOut.close();

			clientSocket.close();
			System.out.println("Arquivo Recebido: Arquivo: cliente_teste.pdf");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	
	}

}
