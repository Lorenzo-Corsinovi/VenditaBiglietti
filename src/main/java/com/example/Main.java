package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List usernames = new ArrayList<String>();
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        Socket mySocket = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        PrintWriter out = new PrintWriter(mySocket.getOutputStream(), true);

        out.println("WELCOME");

        while (true) {
            String loginUsername = in.readLine();
            if(!usernames.contains(loginUsername)){
                usernames.add(loginUsername);
                break;
            }
            out.println("ERR USERNAME");
        }
        out.println("OK");
    }
}