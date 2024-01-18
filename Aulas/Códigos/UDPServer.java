import java.io.*;
import java.net.*;

class UDPServer {

	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			try {
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
				serverSocket.receive(receivePacket);
				UDP_SERVER_RECEBER t1= new UDP_SERVER_RECEBER(receivePacket);
				t1.start();

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}