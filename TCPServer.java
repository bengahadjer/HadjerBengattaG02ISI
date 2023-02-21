import java.io.*;
import java.net.*;

public class TCPServer {
  public static void main(String[] args) throws Exception {
    ServerSocket welcomeSocket = new ServerSocket(6789);
    System.out.println("Waiting for clients...");
    
    while (true) {
      Socket connectionSocket = welcomeSocket.accept();
      System.out.println("Client connected from: " + connectionSocket.getInetAddress());
      
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);
      
      String str1 = inFromClient.readLine();
      String str2 = inFromClient.readLine();
      System.out.println("Strings received: " + str1 + ", " + str2);
      
      if (str1.contains(str2)) {
        outToClient.println(str1 + " contains " + str2);
      } else {
        outToClient.println(str1 + " does not contain " + str2);
      }
    }
  }
}
