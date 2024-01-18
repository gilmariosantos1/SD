import java.io.*;
import java.net.*;
import java.util.Scanner;

class UDPClient {
	public static void main(String args[]) throws Exception {
		for (int i = 0; i < 10000; i++) {
			new UDP_Envio(i).start();
		}
	}
}