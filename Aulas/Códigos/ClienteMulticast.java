import java.net.*;

public class ClienteMulticast {

	public static void main(String[] args) {

		while (true) {

			try {
				//Classe java para trabalhar com multicast ou broadcast
				MulticastSocket mcs = new MulticastSocket(6000);//porta como parametro
				//Endereço de um grupo multicast
				InetAddress grp = InetAddress.getByName("239.0.0.1");
				//ingressando em um grupo para receber mensagens enviadas para o mesmo
				mcs.joinGroup(grp);
				byte rec[] = new byte[256];
				DatagramPacket pkg = new DatagramPacket(rec, rec.length);
				mcs.receive(pkg);//recebendo os dados enviados via multicast para o endereço acima
				String data = new String(pkg.getData(), 0, pkg.getLength());
				System.out.println("Dados recebidos: " + data);
			}

			catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}
}
