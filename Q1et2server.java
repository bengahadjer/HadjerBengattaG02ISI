package tpRESeau;
	import java.io.DataInputStream;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.util.Scanner;

public class Q1et2server {
	
	private static String find(String s,String v){
		  
		    
		    int index = v.indexOf(s);
		    
		    if(index == - 1) {
		      System.out.println("Le mot "+s+" n'existe pas.");
		    } else {
		      System.out.println("Le mot :"+s+" se trouve à l'index : "+ index);
		    }
			return v;
		  }
		
		
		public static void main(String args[]){
			Scanner scanner= new Scanner (System.in);
		
		try{int port=2225;
		
		ServerSocket serverSocket = new ServerSocket(port);  
		 
		System.out.println("Waiting for Client...");
		 
		//establish connection
		Socket socket = serverSocket.accept();
		 
		System.out.println("Client Connected...");
		 
		//fetch incoming message
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String  message = (String)dis.readUTF();
		//System.out.println("Client message: " + message);  
		//mess2
		DataInputStream dis1 = new DataInputStream(socket.getInputStream());
		String  message1 = (String)dis1.readUTF();
		//System.out.println("Client message: " + message1); 
		//close connection
		String index= find(message1,message);
		serverSocket.close();
		}catch(Exception e){
		e.printStackTrace();
		}
		}
	}


