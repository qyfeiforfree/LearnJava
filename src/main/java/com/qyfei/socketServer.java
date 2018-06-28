package com.qyfei;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class socketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        int count = 0;
        System.out.println("**********服务即将启动***********");
        Socket socket = null;
        while (true) {
            socket = serverSocket.accept();
            socketServerThread serverThread = new socketServerThread(socket);
            serverThread.start();
            count++;
            System.out.println("客户端数量：" + count);
            InetAddress address = socket.getInetAddress();
            System.out.println("客户端地址：" + address.getHostAddress());
        }
    }


}

