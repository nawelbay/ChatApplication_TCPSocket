package org.example;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            Socket s= new Socket("localhost", 1234);
            Scanner sc= new Scanner(System.in);
            //to read
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            //to send
            OutputStream os= s.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);


            while (true)
            {
                System.out.println("serveur a dit  " + br.readLine());
                String req=sc.nextLine();
                pw.println(req);

            }
        } catch (Exception e) {

            e.printStackTrace();
        }







    }

}
