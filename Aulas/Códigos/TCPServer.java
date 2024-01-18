import java.net.*;

class TCPServer {
	public static void main(String argv[]) throws Exception {
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			Server_Cliente sc = new Server_Cliente(connectionSocket);
			sc.start();
		}
	}
}