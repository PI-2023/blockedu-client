import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;



public class ViewEmissaoCertificado {
    private Socket cliente;
    BufferedReader leitor;
    PrintWriter escritor;
    String cpf;
    // AlunoVO aluno;

    public ViewEmissaoCertificado(Socket cliente, BufferedReader leitor, PrintWriter escritor){
        this.cliente = cliente;
        this.leitor = leitor;
        this.escritor = escritor;
        View();
    }

    void View(){
        try{
            /// consulta o cpf do aluno
            escritor.println("\033[H\033[2J" + "Informe o CPF do aluno: (digite 'sair' para finalizar)");
            this.cpf = leitor.readLine();
            if (cpf.equalsIgnoreCase("sair")){
                this.cliente.close();
            } else {
                try {

                    //consulta cpf
                    // if (aluno.getCpf(cpf));{  
                    // }
                    escritor.println("ideia repassada em ViewEmitirCertificado");
                    
                } catch (Exception e) {
                    escritor.println("\nDados incorretos!");
                }
            }
            
        }catch(IOException e){
            System.err.println("O Cliente fechou conexão! ");
        }
    }
}
