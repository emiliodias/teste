import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws InterruptedException {
		// declarando o servidor
		ServerSocket serv = null;
		// declarando o socket de comunica��o
		Socket s = null;
		// declarando o leitor para a entrada de dados
		BufferedReader entrada = null;
		
		BufferedWriter saida = null;
		//Testeeeeeeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		try {
			// cria o ServerSocket na porta 7000 se estiver dispon�vel
			serv = new ServerSocket(7000);
			// aguarda uma conex�o na porta especificada e retorna
			// o socket que ir� comunicar com o cliente
			
			while(true) {
			
				s = serv.accept();
				
				Thread.sleep(10000);
				
				entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
				
				System.out.println(entrada.readLine());

				saida = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				
				saida.write("Resposta...");
				
			}
		}
		// trata poss�veis exce��es de input/output. Note que as
		// exce��es s�o as mesmas utilizadas para as classes de
		// java.io
		catch (IOException e) {
			System.out.println("Algum problema ocorreu para criar ou receber o socket.");
		} finally {
			try {
				// encerra o socket de comunica��o
				s.close();
				// encerra o ServerSocket
				serv.close();
			} catch (IOException e) {
			}
		}
	}
}
