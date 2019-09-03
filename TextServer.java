package highSocket;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TextServer {
    public static void main(String []args) throws Exception{
        System.out.println("Server start");
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept();
        /*BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(new FileWriter("C:\\javaTest.txt"));
        String line = null;
         */
        InputStream in =s.getInputStream();
        FileOutputStream fos = new FileOutputStream("C:\\javaTest.txt");//接收文件地址
        System.out.println("start:");
        byte[] buffer = new byte[1024];
        int len = 0;
        int data = 0;

        while ((len = in.read(buffer)) != -1) {
            //System.out.println(line);
            //out.println(line);
            fos.write(buffer, 0, len);
            data += len;
        }
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
        pw.println("upload successful");
        pw.close();
        s.close();
        ss.close();
    }
}
