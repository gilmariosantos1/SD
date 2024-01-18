import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDP_SERVER_RECEBER extends Thread{
	private DatagramPacket receivePacket;
	
	public UDP_SERVER_RECEBER(DatagramPacket receivePacket){
		this.receivePacket = receivePacket;
	}
	
	

	public void run(){
		try{
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
			try {
				String sentence = new String(receivePacket.getData(), 0,
						receivePacket.getLength());
				System.out.println(receivePacket.getAddress()+": "+receivePacket.getPort() + " ---"
						+ sentence);
				InetAddress IPAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();
				String capitalizedSentence = sentence.toUpperCase();
				sendData = capitalizedSentence.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, IPAddress, port);
				DatagramSocket ds = new DatagramSocket();
				ds.send(sendPacket);
				ds.close();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		}catch(Exception ex){
			
		}
		
		
	}
	

}
