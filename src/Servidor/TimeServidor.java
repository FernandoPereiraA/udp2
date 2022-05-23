package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class TimeServidor{
    static DatagramSocket socket ;

    public TimeServidor() {  
    }
    
     public static void main(String[] args) {
        try {
            socket = new DatagramSocket(9090);
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while(true) {
                System.out.println("Escuchando...");
                socket.receive(packet);          
                
                //muestro el mensaje que le envia el cliente
                System.out.println(new String(buffer));
                
                //genero cadena  fecha
                String toClient=new Date().toString();
                //cargo el buffer
                buffer = toClient.getBytes();
                System.out.println(new String(buffer));
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                //creo el datagrama y lo envio al cliente
                packet = new DatagramPacket(buffer, buffer.length, address, port);
                socket.send(packet);
            }
            
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
