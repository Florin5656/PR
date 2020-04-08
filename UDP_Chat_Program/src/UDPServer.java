import java.net.*;

public class UDPServer extends Thread
{
   private DatagramSocket server_socket = null;
   static String api ;
public void run()
   {
      int measure;   
     // Specify size of UDP chunk to receive
      byte[] receive_data = new byte[1024];
       try
       {           
        server_socket = new DatagramSocket(5001);
         System.out.println ("UDPServer Waiting for client..");
         sleep(400);
         while(true)
         {
        //Create the space for received datagram 
          DatagramPacket receive_packet = new DatagramPacket(receive_data,
                                              receive_data.length);
                  //Receive the datagram
                  server_socket.receive(receive_packet);

                  String data = new String(receive_packet.getData(),0 ,receive_packet.getLength());
          
                  data = UDPClient.encryptString(data);
                 
                 measure = receive_packet.getLength();
                   //Get the IP address from the sender
                  InetAddress IPAddress = receive_packet.getAddress();   
                  
                 
                  if (data.equals("q") || data.equals("Q"))
                  break;
                  else {
                  ChatGUI.seterTexte("\n");  
                  ChatGUI.seterTexte("( " + IPAddress + " , " +  measure +  " ) They said :" + data);
                //  System.out.println("( " + IPAddress + " , " + measure +  " ) They said :" + data );
                  }
         }
       
      }
       catch(Exception e)
       {
           System.out.println("Server Error: " + e);
           ChatGUI.seterTexte("Server Error: " + e);
       }
   }


}
