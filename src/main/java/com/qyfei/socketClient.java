package com.qyfei;

import java.io.*;
import java.net.Socket;


public class socketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 18888);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("用户名：tony，密码：123465");
        printWriter.flush();
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info = null;
        while ((info = bufferedReader.readLine()) != null) {
            System.out.println("------服务器告诉我们-------");
            System.out.println(info);
        }
        bufferedReader.close();
        inputStreamReader.close();
        is.close();
        printWriter.close();
        outputStream.close();
        socket.close();


    }
}
