import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer extends Thread{
    public  void run()
    {
        try {
            DatagramSocket serverSocket = new DatagramSocket(60000);
            byte[] receiveData = new byte[202400];
            byte[] sendData = new byte[20480];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                System.out.println("Received");
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                sendData = receivePacket.getData();
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(receivePacket);
                System.out.println("Sent");
                receiveData = new byte[102400];
                sendData = new byte[102400];
            }
        }catch(IOException e){}
    }
}
