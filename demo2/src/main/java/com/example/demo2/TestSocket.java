package com.example.demo2;

import javax.sound.sampled.AudioFormat;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TestSocket {

    public static void main(String[] args) throws Exception {
        Connect1();
    }

    private static List<Socket> list=new ArrayList<Socket>();


    private static void Connect1() throws Exception
    {

        /* */
        for(int i=0;i<1000000;i++)
        {
            //客户端
            //1、创建客户端Socket，指定服务器地址和端口
            //Socket socket =new Socket("172.16.0.100",8081);
            Socket socket =new Socket("127.0.0.1",8081);

            /*
            //2、获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
            pw.write("中文");
            pw.flush();
            socket.shutdownOutput();

            //3、获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            */


            list.add(socket);

            System.out.println("现在的数据为="+i);

        }


        //客户端
        //1、创建客户端Socket，指定服务器地址和端口
        //Socket socket =new Socket("172.16.0.100",8081);
        Socket socket =new Socket("127.0.0.1",8081);

        //2、获取输出流，向服务器端发送信息
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
        pw.write("中文");
        pw.flush();
        socket.shutdownOutput();

        //3、获取输入流，并读取服务器端的响应信息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while((info=br.readLine())!=null){
            System.out.println("我是客户端，服务器说："+info);
        }

        //4、关闭资源
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }

    private static void Connect() throws Exception
    {

        /*
        for(int i=0;i<10000;i++)
        {

        }
        */

        //客户端
        //1、创建客户端Socket，指定服务器地址和端口
        Socket socket =new Socket("172.16.0.100",8081);

        //2、获取输出流，向服务器端发送信息
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
        pw.write("中文");
        pw.flush();
        socket.shutdownOutput();

        //3、获取输入流，并读取服务器端的响应信息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while((info=br.readLine())!=null){
            System.out.println("我是客户端，服务器说："+info);
        }

        //4、关闭资源
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }

}
