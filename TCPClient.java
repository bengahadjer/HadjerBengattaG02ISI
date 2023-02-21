import java.io.*;
import java.net.*;

public class TCPClient {
  public static void main(String[] args) throws Exception {
    Socket clientSocket = new Socket("localhost", 6789);
    System.out.println("Client address: " + clientSocket.getLocalAddress() + " Port: " + clientSocket.getLocalPort());
    System.out.println("Server address: " + clientSocket.getInetAddress() + " Port: " + clientSocket.getPort());
    
    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
    System.out.println("1 chaine: ");
    String str1 = inFromUser.readLine();
System.out.println("2 chaine: ");
    String str2 = inFromUser.readLine();
    System.out.println("Strings sent: " + str1 + ", " + str2);
    
    outToServer.println(str1);
    outToServer.println(str2);
    
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    String response = inFromServer.readLine();
    System.out.println("Response fr