package highSocket;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TextClient {
    public static void main(String []args) throws Exception{
        System.out.println("Client start");
        Socket s = new Socket("127.0.0.1", 12345);
        BufferedReader br = new BufferedReader(new FileReader("C:\\02.txt"));//发送文件地址
        PrintWriter out =  new PrintWriter(s.getOutputStream(), true);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            out.println(line);
        }
        s.shutdownOutput();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String confirmMsgStr = br2.readLine();
        System.out.println(confirmMsgStr);
        br2.close();
        s.close();
    }
}
