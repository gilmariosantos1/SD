import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Envio extends Thread {
	private int codigo;
	
	public UDP_Envio(int codigo){
		this.codigo = codigo;
	}

	public void run() {
		try {

			InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			DatagramSocket clientSocket = new DatagramSocket();
			sendData = String.valueOf(codigo).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			clientSocket.receive(receivePacket);
			String modifiedSentence = new String(receivePacket.getData(), 0,
					receivePacket.getLength());
			System.out.println("FROM SERVER:" + modifiedSentence);
			clientSocket.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
