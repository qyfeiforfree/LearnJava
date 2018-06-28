package com.qyfei;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {


        /*
         * 发送服务端数据
         * */
        InetAddress address = InetAddress.getByName("localhost");

        int port = 8800;

        byte[] data = "用户名：admin，密码：admin".getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

        DatagramSocket socket = new DatagramSocket();

        socket.send(packet);

        /*
         * 接受服务端数据
         * */

        byte[] data2 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data2, data2.length);
        socket.receive(packet1);
        String reply = new String(data2, 0, packet1.getLength());
        System.out.println("+++++++客户端接收+++++++");
        System.out.println(reply);
        socket.close();
    }

}

