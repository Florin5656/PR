import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
//import java.io.*;
import java.util.Random;

public class UDPClient extends Thread
{
    ChatGUI gui;

       // The key for 'encrypting' and 'decrypting'.
       static final String key = "Encrypt"; 
       //Simulate packet loss rate
       private static final double LOSS_RATE = 0.3;
       
       public static String encryptString(String str)
   {
      StringBuffer sb = new StringBuffer (str);
      
      int lenStr = str.length();
      int lenKey = key.length();	
      // For each character in our string, encrypt it...
      for ( int i = 0, j = 0; i < lenStr; i++, j++ ) 
      {
         if ( j >= lenKey ) j = 0; // Wrap 'round to beginning of key string.
          // XOR the chars together. Must cast back to char to avoid compile error. 
         sb.setCharAt(i, (char)(str.charAt(i) ^ key.charAt(j)));
       
         ChatGUI.seterTexte(str);
      }
      
      return sb.toString();
   }
   
       
  public void run()
  {
      //create random number generator for use in simulated packet loss.
       
    try
    {
      // Specify size of UDP chunk to send
      byte[] send_data = new byte[1024];
      @SuppressWarnings("unused")
	  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));//Create input stream
      DatagramSocket client_socket = new DatagramSocket(); //Create a client socket 
      InetAddress IPAddress =  InetAddress.getByName("localhost"); //Translate hostname to IP address using dns

      while (true)
      {

      //	System.out.println("Type Something (q or Q to quit): ");
        ChatGUI.seterTexte("Type Something (q or Q to quit): ");
        sleep(200);
        //String data = inFromUser.readLine();
        String data = ChatGUI.geterTexte();
       // data = encryptString(data);
      //  ChatGUI.seterTexte("Input text: ");
      	if (data.equals("q") || data.equals("Q"))
      	break;
      	else
      	{         
      	send_data = data.getBytes();
        
        //Create datagram packet with data-to-send, length, IP address, port
        DatagramPacket send_packet = new DatagramPacket(send_data, send_data.length, IPAddress, 5002);
         // Decide whether to reply, or simulate packet loss.
        
        Random random = new Random();
         if (random.nextDouble() < LOSS_RATE) {
            System.out.println("Successfully resent data :" + data);
            //ChatGUI.seterTexte("Successfully resent:" + data);
            sleep(200);
            client_socket.send(send_packet);
            
         }
         else 
        //Send datagram to server
         client_socket.send(send_packet);          
         // System.out.println("You wrote:     " + data);
          ChatGUI.setLabel("You wrote:     " + data);
        }
      }
      client_socket.close();
      System.exit(0);
   }
   catch (Exception e)
   {
      System.out.println("Client Error: " + e);
      ChatGUI.seterTexte("Client Error: " + e);
      
   }
 }
}
