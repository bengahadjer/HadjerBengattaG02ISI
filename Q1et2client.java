package tpRESeau;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Q1et2client {
	
	
		
		public static void main(String args[]){
		String message,message1;
		Scanner sc = new Scanner(System.in);
		try{int port=2225;
		
		Socket socket = new Socket("localhost", port);
		 
		System.out.println("Connected with Server...");
		System.out.println("enter a message: ");
		message = sc.nextLine();
		 
		
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		dout.writeUTF(message);
		
		System.out.println("enter a message: ");
		message1 = sc.nextLine();
		 
		
		DataOutputStream dout1 = new DataOutputStream(socket.getOutputStream());
		dout1.writeUTF(message1);
		
		dout1.flush();
		dout.flush();
		dout.close();
		dout1.close();
		socket.close();  
		}catch(Exception e){
		e.printStackTrace();
		}
		}
		
	}


