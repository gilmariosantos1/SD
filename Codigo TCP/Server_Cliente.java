import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Server_Cliente extends Thread {

	private Socket s;

	public Server_Cliente(Socket s) {
		this.s = s;
	}

	public void run() {

		try {
			
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(
					s.getOutputStream());
			String clientSentence = inFromClient.readLine();
			System.out.println(s.getRemoteSocketAddress() + " - "
					+ clientSentence);
			String capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
