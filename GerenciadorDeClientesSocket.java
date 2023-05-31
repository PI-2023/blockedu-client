import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GerenciadorDeClientesSocket extends Thread {

    private Socket cliente;
    private String nomeCliente;

    public GerenciadorDeClientesSocket(Socket cliente) {
        this.cliente = cliente;
        start();
    }

    @Override
    public void run() {
        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            escritor.println("Por favor, Insira seu nome! ");
            String msg = leitor.readLine();
            this.nomeCliente = msg;
            escritor.println("Olá, " + this.nomeCliente);

            while (true) {
                msg = leitor.readLine();
                if (msg.toLowerCase().equalsIgnoreCase("sair")){
                    this.cliente.close();
                }
                escritor.println(nomeCliente + ", Você disse: " + msg);
            }

        } catch (IOException e) {
            System.err.println("O Cliente fechou conexão! ");
            e.printStackTrace();
        }

    }
}
