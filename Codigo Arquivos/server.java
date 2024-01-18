import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		ServerSocket server = new ServerSocket(8001);
		Socket s = server.accept();
		BufferedReader inFromClient = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		//aguardando recebimento do nome do arquivo - timeout 10 segundos
		String arquivo = inFromClient.readLine();
		//verifica se o arquivo existe
		//se existir envia o arquivo
        FileInputStream fileIn = new FileInputStream(arquivo);           
        OutputStream socketOut = s.getOutputStream();
		 // Criando tamanho de leitura
        byte[] cbuffer = new byte[1024];
        int bytesRead;

        // Lendo arquivo criado e enviado para o canal de transferencia
        System.out.println("Enviando Arquivo: "+arquivo);
        while ((bytesRead = fileIn.read(cbuffer)) != -1) {
            socketOut.write(cbuffer, 0, bytesRead);
            socketOut.flush();
        }
        fileIn.close();
        s.close();
        System.out.println("Arquivo Enviado!");

		
		
		}catch(Exception ex)
		{
			
		}

	}

}
