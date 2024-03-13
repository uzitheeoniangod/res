package com.epemla.res.res;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class TcpServer {
    public static void main(String[] args) {
        try {
            // 创建tcp服务器，并绑定端口号
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器已启动，等待客户端连接。。。");

            while (true) {


                //接收客户端的连接请求
                Socket socket = serverSocket.accept();
                System.out.println("客户端连接成功");
                //获取输入输出流
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                //读取客户端数据
                byte[] bytes = new byte[1024];
                int bytesRead = inputStream.read(bytes);
                String receivedMessage = new String(bytes, 0, bytesRead);
                System.out.println("数据是：" + receivedMessage);
                //发送响应数据给客户端
                String responseMessage = "收到数据，发送响应";
                outputStream.write(responseMessage.getBytes());


                //关闭连接



            }
            }catch(IOException e){
                e.printStackTrace();


        }
    }
}
