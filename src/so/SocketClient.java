package so;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import io.github.cdimascio.dotenv.Dotenv;

public class SocketClient {
    private static Dotenv env = Dotenv.load();
    private static final String HOST = SocketClient.env.get("SV_HOST");
    private static final int PORT = Integer.parseInt(SocketClient.env.get("SV_PORT"));

    public SocketClient() { }

    public String enviarCertificado(String certificado) {
        try (Socket socket = new Socket(HOST, PORT)) {

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            outputStream.writeUTF(certificado);
            outputStream.flush();
            
            String hash = inputStream.readUTF();

            socket.close();

            return hash;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
