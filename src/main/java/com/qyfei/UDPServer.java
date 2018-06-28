package com.qyfei;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {

        /*
         * 接受客户端数据
         * */
        DatagramSocket socket = new DatagramSocket(8800);
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        System.out.println("=============服务器已就绪=================");
        socket.receive(packet);
        String info = new String(data, 0, packet.getLength());

        System.out.println("=============服务器接收到=================");
        System.out.println(info);


        /*
         * 返回客户端数据
         * */
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "欢迎您！".getBytes();

        DatagramPacket packet1 = new DatagramPacket(data2, data2.length, address, port);
        socket.send(packet1);
        socket.close();

    }
}
