import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            System.out.println("\033[H\033[2J" +"Startando o servidor...");
            server = new ServerSocket(5555);
            System.out.print("Servidor Startado");
            Socket s;
            while ((s = server.accept()) != null) {
                new GerenciadorDeClientesSocket(s);
            }
        } catch (IOException e) {

            try {
                if (server != null)
                    server.close();
                e.printStackTrace();
            } catch (IOException e1) {
                System.err.println("A porta não está disponível ou o Servidor foi fechado!");
            }
        }
    }
}
