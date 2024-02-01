import java.io.*;
import java.net.Socket;

public class Cliente {

    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            // Solicita o nome do arquivo ao usuário
            System.out.print("Digite o nome do arquivo desejado: ");
            String fileName = userInput.readLine();

            // Cria uma conexão com o servidor
            try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                 BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 DataInputStream fileInput = new DataInputStream(socket.getInputStream())) {

                // Configura um timeout para a conexão
                socket.setSoTimeout(60000);

                // Envia o nome do arquivo ao servidor
                PrintWriter outputStream = new PrintWriter(socket.getOutputStream(), true);
                outputStream.println(fileName);

                // Recebe a resposta do servidor
                String response = serverInput.readLine();

                if (response.equals("Arquivo não encontrado")) {
                    System.out.println(response);
                } else {
                    // Salva o arquivo em disco
                    try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = fileInput.read(buffer)) != -1) {
                            fileOutputStream.write(buffer, 0, bytesRead);
                        }
                        System.out.println("Arquivo recebido com sucesso.");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}