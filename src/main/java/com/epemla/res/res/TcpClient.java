package com.epemla.res.res;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class TcpClient {
    public static void main(String[] args) {
        try {
            // 创建tcp客户端，并指定服务器的IP地址和端口号
            Socket clientsocket=new Socket("localhost",8888);
            //获取输入输出流
            InputStream inputStream=clientsocket.getInputStream();
            OutputStream outputStream=clientsocket.getOutputStream();
            //发送数据给服务器端
            String message="11111111";
            outputStream.write(message.getBytes());
            //读取客户端响应的数据
            byte[] bytes=new byte[1024];
            int bytesRead=inputStream.read(bytes);
            String receivedMessage=new String(bytes,0,bytesRead);
            System.out.println("收到服务器响应："+ receivedMessage);


            //关闭连接


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
