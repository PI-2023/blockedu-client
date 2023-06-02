package so;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import io.github.cdimascio.dotenv.Dotenv;

public class SocketClient {
    private static Dotenv env = Dotenv.load();
    private static final String HOST = SocketClient.env.get("SV_HOST");
    private static final int PORT = Integer.parseInt(SocketClient.env.get("SV_PORT"));

    public SocketClient() { }

    public String enviarCertificado(String certificado) {
        try (Socket socket = new Socket(HOST, PORT)) {
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            outputStream.write(certificado.getBytes());
            outputStream.flush();

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String hash = new String(buffer, 0, bytesRead);

            return hash;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
