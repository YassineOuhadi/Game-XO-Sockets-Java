
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Game extends Thread
{
	private int numClient;
	private Socket client; 
	static int play=0;
	static int test=0;static int bool=0;
	//private ArrayList<Socket> listClientsConnectee;
	private Socket [] listClientsConnectee;
	private ArrayList<String> player1,player2;
	
	public Game(int numClient, Socket sock_client, Socket [] listClientsConnectee)
	{
		this.numClient = numClient;
		this.client = sock_client;
		this.listClientsConnectee = listClientsConnectee;
		this.player1= new ArrayList<String>();
		this.player2= new ArrayList<String>();
	}
	
	public void run() {
		
		System.out.println("Client <"+ numClient + "> connected...");
		
		try {
			
			OutputStream os = client.getOutputStream();
			PrintWriter writer= new PrintWriter(os,true);
			
			writer.println(numClient);
			if(test==0) {writer.println("Waiting for another player"+"\n");test=1;}		
			if(this.numClient==2) {
				writer.println("start"+"\n");
				OutputStream b = this.listClientsConnectee[0].getOutputStream();
				PrintWriter w= new PrintWriter(b,true);
				w.println("Other player connected . Your move."+"\n");
			};
			InputStream is;
			is = client.getInputStream();
			InputStreamReader ipsr=new InputStreamReader(is);
			BufferedReader reader=new BufferedReader(ipsr);
			
			String msg;
			
			while(true)
			{
				msg=reader.readLine();
				
				if(msg!=null)
				{
					String ss="wait";
					if(msg.equals(ss)) {
						if(play==0) {
						writer.println("Please wait"+"\n");play=1;};
					}
					else {
					if(msg.substring(0, 3).equals("btn")) {
						play=0;
						writer.println("Valid move"+"\n");
						if(this.numClient==1) {
							player1.add(msg);
							/*if(player1.get(0).equals("btn1")) {
								writer.println("succee"+"\n");bool=1;
							};*/
							if(check(player1)==1) {
								writer.println("succee"+"\n");bool=1;
							};
						}
						else if(this.numClient==2) {
							player2.add(msg);
							/*if(player2.get(0).equals("btn9")) {
								writer.println("succee"+"\n");bool=1;
							};*/
							if(check(player2)==1) {
								writer.println("succee"+"\n");bool=1;
							};
						};
					};
					for(Socket socket : listClientsConnectee)
					{  
						if(socket!=client)
						{
							OutputStream aos = socket.getOutputStream();
							PrintWriter other_sock_writer= new PrintWriter(aos,true);
							//if(this.numClient==1){msg="X";}else if(this.numClient==2){msg="O";};
							other_sock_writer.println(msg);
							if((msg.length()==4)&&(bool==0)) {other_sock_writer.println("Your turn"+"\n");};
							
						}
					}
					};
				}	
				
			 }
			
		} catch (IOException e) {}
		
	}
	private int check(ArrayList<String> player) {
		int i=0;
		int j=0;
		int k=0;
		int l=0;
		int m=0;
		int n=0;
		int p=0;
		int q=0;
		for(String s : player) {
			if((s.equals("btn1"))||(s.equals("btn4"))||(s.equals("btn7"))) {i++;};
			if((s.equals("btn1"))||(s.equals("btn2"))||(s.equals("btn3"))) {j++;};
			if((s.equals("btn1"))||(s.equals("btn5"))||(s.equals("btn9"))) {k++;};
			if((s.equals("btn3"))||(s.equals("btn5"))||(s.equals("btn7"))) {l++;};
			if((s.equals("btn4"))||(s.equals("btn5"))||(s.equals("btn6"))) {m++;};
			if((s.equals("btn7"))||(s.equals("btn8"))||(s.equals("btn9"))) {n++;};
			if((s.equals("btn2"))||(s.equals("btn5"))||(s.equals("btn8"))) {p++;};
			if((s.equals("btn3"))||(s.equals("btn6"))||(s.equals("btn9"))) {q++;};
		};
		if((i==3)||(j==3)||(k==3)||(l==3)||(m==3)||(n==3)||(p==3)||(q==3)) {return 1;}
		else {return 0;}
	};
}

