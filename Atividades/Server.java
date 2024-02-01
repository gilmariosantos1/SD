import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final String BASE_DIR = "arquivos";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor pronto para receber conexões.");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão aceita de " + clientSocket.getInetAddress());

                // Submeter a tarefa para um thread do pool
                executorService.submit(() -> handleClient(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream())) {

            // Configura um timeout para a conexão
            clientSocket.setSoTimeout(60000);

            // Recebe o nome do arquivo solicitado
            String fileName = reader.readLine();

            // Caminho completo do arquivo
            String filePath = BASE_DIR + File.separator + fileName;

            // Verifica se o arquivo existe
            File file = new File(filePath);
            if (file.exists()) {
                // Envia o conteúdo do arquivo
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            } else {
                // Se o arquivo não existir, informa ao cliente
                outputStream.writeUTF("Arquivo não encontrado");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Fecha a conexão com o cliente
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
