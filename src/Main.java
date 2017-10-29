public class Main {
    public static void main(String args[]) throws Exception
    {
        System.out.println("Server's started");
        new Thread(new UDPServer()).start();
    }
}
