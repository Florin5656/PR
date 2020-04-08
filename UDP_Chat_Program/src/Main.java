public class Main
{

    public static void main(String[] args) throws Exception
    {
        new ChatGUI().setVisible(true);
        
        UDPServer myServer = new UDPServer();
        UDPClient myClient = new UDPClient();
     
        myServer.start();
        myClient.start();
        
        
    }
}
