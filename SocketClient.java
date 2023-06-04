package so;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        String certificado = "Transaction Data";

        try {
            Socket client = new Socket("127.0.0.1", 7070);
            System.out.println("\033[H\033[2J" + "Cliente conectado");
            DataOutputStream envio = new DataOutputStream(client.getOutputStream());
            envio.writeUTF(certificado);
            DataInputStream leitor = new DataInputStream(client.getInputStream());
            String hash = leitor.readUTF();
            System.out.println("Servidor disse: Hash gerado --- " + hash);
            envio.flush();
            client.close();
        } catch (Exception e) {
            System.out.println("Erro durante a conexão");
        }
    }
}
