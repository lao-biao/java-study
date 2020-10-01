package com.training.day04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 周
 * @title MyServer
 * @date 2020/7/16 15:25
 * @description
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder("");
        String res;
        while ((res = bf.readLine()) != null) {
            if (res.isEmpty())
                break;
            sb.append(res);
            sb.append("\n");
        }

        System.out.println(sb.toString());

        // 输出
        OutputStream os = socket.getOutputStream();


        os.write("HTTP/1.1 200 OK\r\n\r\n<p>Hello World.</p>".getBytes());

        os.close();

        bf.close();
        is.close();
        socket.close();
        server.close();


    }
}
