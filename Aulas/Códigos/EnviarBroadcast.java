import java.net.*;

public class EnviarBroadcast {

	public static void main(String[] args) {

		try {
			byte[] b = "Testando Broadcast".getBytes();
			//Definindo o endereço de envio do pacote neste caso o endereço de broadcast
			InetAddress addr = InetAddress.getByName("255.255.255.255");
			DatagramPacket pkg = new DatagramPacket(b, b.length, addr,6001);
			DatagramSocket ds = new DatagramSocket();
			ds.send(pkg);//enviando pacote broadcast
		}
		catch (Exception e) {
			System.out.println("Nao foi possivel enviar a mensagem");
		}

	}

}
