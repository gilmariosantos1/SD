import java.net.*;

public class EnviarMulticast {

	public static void main(String[] args) {

		try {
			byte[] b = "ops".getBytes();
			//Definindo o endere�o de envio do pacote neste caso o endere�o de multicast
			InetAddress addr = InetAddress.getByName("239.0.0.1");
			DatagramPacket pkg = new DatagramPacket(b, b.length, addr,8000);
			DatagramSocket ds = new DatagramSocket();
			ds.send(pkg);//enviando pacote multicast
		}
		catch (Exception e) {
			System.out.println("Nao foi possivel enviar a mensagem");
		}

	}

}
