package so;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import bc.Block;
import bc.BlockChain;

public class GerenciadorDeClientesSocket extends Thread {
    private Socket client;
    private BlockChain blockChain;

    public GerenciadorDeClientesSocket(Socket client, BlockChain blockChain) {
        this.client = client;
        this.blockChain = blockChain;
        start();
    }

    @Override
    public void run() {
        try {
            DataInputStream leitor = new DataInputStream(client.getInputStream());

            if (leitor.available() > 0) {
                String certificado = leitor.readUTF();
                System.out.println("Certificado recebido!" + certificado);

                Block block = this.blockChain.createBlock(certificado);
                this.blockChain.addBlock(block);
                System.out.println("Hash gerado: " + block.getHash());

                DataOutputStream envio = new DataOutputStream(client.getOutputStream());
                envio.writeUTF(block.getHash());
                envio.flush();

            } else {
                System.out.println("Certificado vazio!");
            }

            client.close();
            System.out.println("Conexão encerrada com o cliente.");
        } catch (IOException e) {
            System.err.println("O Cliente fechou conexão!");
            e.printStackTrace();
        }

    }
}
