import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class GerenciadorDeClientesSocket extends Thread {
    private Socket cliente;

    public GerenciadorDeClientesSocket(Socket cliente) {
        this.cliente = cliente;
        start();
    }

    @Override
    public void run() {
        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            new ViewEmissaoCertificado(cliente,leitor,escritor);
        } catch (IOException e) {
            System.err.println("O Cliente fechou conexão! ");
            e.printStackTrace();
        }

    }
}
