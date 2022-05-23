package Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class DataTimeCliente {
    
     public DataTimeCliente() {  
 }
    
    public static void main(String args[]) {
        byte[] buffer = new byte[256];
        DatagramSocket socket;
        try {
            socket = new DatagramSocket();
            InetAddress address= InetAddress.getByName("localhost");
            System.out.println("Cliente solicitando conexion");
            String mensaje="Cliente conectado";//mensaje enviado al server
            buffer = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,9090);
            socket.send(packet);
            packet = new DatagramPacket(buffer,buffer.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }       
    }
}
