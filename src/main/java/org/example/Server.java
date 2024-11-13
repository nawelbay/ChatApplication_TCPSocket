package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {


        try {
            ServerSocket s= new ServerSocket(1234);
            System.out.println("Waiting for a connexion");
            Socket ss= s.accept();
            System.out.println("client "+ ss.getRemoteSocketAddress() + "Connected");
            InputStream ip= ss.getInputStream();
            InputStreamReader ips= new InputStreamReader(ip);
            BufferedReader br= new BufferedReader(ips);
            Scanner scanner= new Scanner(System.in);
            OutputStream op=ss.getOutputStream();
            PrintWriter prt=new PrintWriter(op, true);

            while (true)
            {
                String sender=scanner.nextLine();
                prt.println(sender);

                String receiver = br.readLine();
                System.out.println("Le client dit:   " + receiver);

            }

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}