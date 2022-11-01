
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args)
	{
		//ArrayList<Socket> listClientsConnectee = new ArrayList<Socket>();
		Socket [] listClientsConnectee= new Socket[2];
		int numClient = 0 ; 
		ServerSocket server;
		
		try {
			
			server = new ServerSocket(2003);
			
			while(true)
			{
				Socket client = server.accept();
				listClientsConnectee[numClient]=client;
				//listClientsConnectee.add(client);
				numClient++;
				new Game(numClient, client, listClientsConnectee).start();
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
