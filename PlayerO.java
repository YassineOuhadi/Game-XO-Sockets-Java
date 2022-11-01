import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.HashMap; // import the HashMap class
import java.util.Map;

public class PlayerO {

	private JFrame frame;
	
	private static Socket sock_client; 
	
	private static int play=0;
		
	static JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerO window = new PlayerO();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PlayerO() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame("X/O");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 275, 355);
		frame.setResizable(false);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLabel toplbl = new JLabel("Your are player O");
		toplbl.setFont(new Font("Gayathri", Font.BOLD, 12));
		toplbl.setBounds(0, 0, 275, 50);
		toplbl.setBounds(0, 0, 275, 50);
		frame.getContentPane().add(toplbl);
		
		btn1 = new JButton();
		btn1.setFont(new Font("Ani", Font.BOLD, 20));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBounds(60, 60, 50, 50);
		frame.getContentPane().add(btn1);
		
	
		btn2 = new JButton();
		btn2.setFont(new Font("Ani", Font.BOLD, 20));
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setBounds(110, 60, 50, 50);
		frame.getContentPane().add(btn2);
		
		btn3 = new JButton();
		btn3.setFont(new Font("Ani", Font.BOLD, 20));
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setBounds(160, 60, 50, 50);
		frame.getContentPane().add(btn3);
		
		btn4 = new JButton();
		btn4.setFont(new Font("Ani", Font.BOLD, 20));
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setBounds(60, 110, 50, 50);
		frame.getContentPane().add(btn4);
		
		btn5 = new JButton();
		btn5.setFont(new Font("Ani", Font.BOLD, 20));
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setBounds(110, 110, 50, 50);
		frame.getContentPane().add(btn5);
		
		btn6 = new JButton();
		btn6.setFont(new Font("Ani", Font.BOLD, 20));
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setBounds(160, 110, 50, 50);
		frame.getContentPane().add(btn6);
		
		btn7 = new JButton();
		btn7.setFont(new Font("Ani", Font.BOLD, 20));
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setBounds(60, 160, 50, 50);
		frame.getContentPane().add(btn7);
		
		btn8 = new JButton();
		btn8.setFont(new Font("Ani", Font.BOLD, 20));
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setBounds(110, 160, 50, 50);
		frame.getContentPane().add(btn8);
		
		btn9 = new JButton();
		btn9.setFont(new Font("Ani", Font.BOLD, 20));
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setBounds(160, 160, 50, 50);
		frame.getContentPane().add(btn9);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 220, 275, 105);
		frame.getContentPane().add(panel);
		
		final JTextArea txt = new JTextArea(6, 23);
		//txt.setText("Player X connected");
		txt.setEditable ( false );
		txt.setTabSize(4);
		final JScrollPane scroll = new JScrollPane ( txt );
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		panel.add(scroll);
		
		try {
			
		sock_client = new Socket("localhost",2003);
		
		InputStream is=sock_client.getInputStream();
		InputStreamReader ipsr=new InputStreamReader(is);
		final BufferedReader reader =new BufferedReader(ipsr);
		
		OutputStream os= sock_client.getOutputStream();
		final PrintWriter writer = new PrintWriter(os,true);
		
		Thread reception = new Thread( new Runnable(){
			
			String msg;

			public void run() 
			{
				while ( true ) 
				{
					try 
					{
						msg=reader.readLine();
						//if(msg=="hh")System.out.print("bb");
						if(msg!=null) {
							
							switch(msg) {
							  case "btn1":
								    btn1.setText("X");
									btn1.setEnabled(false);
									play=0;
							    break;
							  case "btn2":
								    btn2.setText("X");
									btn2.setEnabled(false);
									play=0;
							    break;
							  case "btn3":
								    btn3.setText("X");
									btn3.setEnabled(false);
									play=0;
							    break;
							  case "btn4":
								    btn4.setText("X");
									btn4.setEnabled(false);
									play=0;
							    break;
							  case "btn5":
								    btn5.setText("X");
									btn5.setEnabled(false);
									play=0;
							    break;
							  case "btn6":
								    btn6.setText("X");
									btn6.setEnabled(false);
									play=0;
							    break;
							  case "btn7":
								    btn7.setText("X");
									btn7.setEnabled(false);
									play=0;
							    break;
							  case "btn8":
								    btn8.setText("X");
									btn8.setEnabled(false);
									play=0;
							    break;
							  case "btn9":
								    btn9.setText("X");
									btn9.setEnabled(false);
									play=0;
							    break;
							  default:
								    if(msg.equals("start")){play=1;msg="Other player will start";};
								    if(msg.equals("succee")){
								    	msg="You succeeded (:";fin();writer.println("lost");
								    };
								    if(msg.equals("lost")){
								    	msg="You losted :)";fin();
								    };
								    if(msg.equals("1")) {msg="Your are connected as Client 1";
								    toplbl.setBorder ( new TitledBorder ( new EtchedBorder (), "Player 1" ) );
								    }
								    else if(msg.equals("2")) {msg="Your are connected as Client 2";
								    toplbl.setBorder ( new TitledBorder ( new EtchedBorder (), "Player 2" ) );
								    }
								    else {
								    txt.append(msg+"\n");
									JScrollBar sb = scroll.getVerticalScrollBar();
									sb.setValue( sb.getMaximum() );	
								    };
							};

							/*btn2.setVisible(false);
							btn2_o.setVisible(true);
							btn2_x.setVisible(false);
							btn2_o.setEnabled(false);*/
						}
					}
					catch (IOException e) 
					{
					}
				}
			}
		});
		
		Thread emission= new Thread(){

			private Scanner sc;
            
			public void run() {
				
					btn1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								if(play==0) {
									btn1.setText("O");
								    btn1.setEnabled(false);
									String str="btn1";
									writer.println(str);
									play=1;
								}
								else if(play==1) {
									writer.println("wait");
								};
						}
					}); 
					
					btn2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								if(play==0) {
									btn2.setText("O");
								    btn2.setEnabled(false);
									String str="btn2";
									writer.println(str);
									play=1;
								}
								else if(play==1) {
									writer.println("wait");
								};
						}
					});
					
					btn3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								if(play==0) {
									 btn3.setText("O");
									 btn3.setEnabled(false);
									 String str="btn3";
									 writer.println(str);
									play=1;
								}
								else if(play==1) {
									writer.println("wait");
								};
						}
					});
					
					btn4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								if(play==0) {
									btn4.setText("O");
							     	btn4.setEnabled(false);
									String str="btn4";
									writer.println(str);
									play=1;
								}
								else if(play==1) {
									writer.println("wait");
								};
						}
					});
					
					btn5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								if(play==0) {
									btn5.setText("O");
									btn5.setEnabled(false);
									String str="btn5";
									writer.println(str);
									play=1;
								}
								else if(play==1) {
									writer.println("wait");
								};
						}
					});
					
					btn6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								if(play==0) {
									btn6.setText("O");
									btn6.setEnabled(false);
									String str="btn6";
									writer.println(str);
									play=1;
								}
								else if(play==1) {
									writer.println("wait");
								};
						}
					});
					
					btn7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								if(play==0) {
									btn7.setText("O");
									btn7.setEnabled(false);
									String str="btn7";
									writer.println(str);
									play=1;
								}
								else if(play==1) {
									writer.println("wait");
								};
						}
					});
					
					btn8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								if(play==0) {
									btn8.setText("O");
									btn8.setEnabled(false);
									String str="btn8";
									writer.println(str);
									play=1;
								}
								else if(play==1) {
									writer.println("wait");
								};
						}
					});
					
					btn9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								if(play==0) {
									btn9.setText("O");
									btn9.setEnabled(false);
									String str="btn9";
									writer.println(str);
									play=1;
								}
								else if(play==1) {
									writer.println("wait");
								};
						}
					});
				
			}
		};
		
		emission.start();
		
		reception.start();
		
		}
		catch ( UnknownHostException uhe)
		{
			uhe.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		};
		
			
	}
	 private void fin() {
	    	btn1.setEnabled(false);
	    	btn2.setEnabled(false);
	    	btn3.setEnabled(false);
	    	btn4.setEnabled(false);
	    	btn5.setEnabled(false);
	    	btn6.setEnabled(false);
	    	btn7.setEnabled(false);
	    	btn8.setEnabled(false);
	    	btn9.setEnabled(false);
		};
}
