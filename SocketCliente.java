import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketCliente {
    public static void main(String[] args) {
        try {
            final Socket cliente = new Socket("127.0.0.1", 5555);

            // lendo mensagem do servidor
            new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

                        while (true) {
                            String mensagem = leitor.readLine();
                            System.out.println("O servidor disse: " + mensagem);
                        }

                    } catch (IOException e) {
                        System.out.println("Impossível ler a mensagem do servidor!");
                    }
                }
            }.start();

            // Escrevendo para o servidor
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader leitorTerminal = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String mensagemTerminal = leitorTerminal.readLine();
                if (mensagemTerminal == null || mensagemTerminal.length() == 0){
                    continue;
                }
                escritor.println(mensagemTerminal);
                if (mensagemTerminal.toLowerCase().equalsIgnoreCase("sair")){
                    System.exit(0);
                }
            }

        } catch (UnknownHostException e) {
            System.out.println("Endereço passado é inválido! ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("O Servidor pode estar fora do ar! ");
        }

    }
}
