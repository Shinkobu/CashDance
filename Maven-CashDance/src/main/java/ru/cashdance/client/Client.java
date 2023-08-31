package ru.cashdance.client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 1; i++) {
            SimpleClient sc = new SimpleClient(i);
            sc.start();
        }
    }
}

class SimpleClient extends Thread {
    private final static String[] COMMAND ={
            "HELLO", "MORNING", "DAY", "EVENING"
    };
    private int cmdNumber;

    public SimpleClient(int cmdNumber) {
        this.cmdNumber = cmdNumber;
    }

    @Override
    public void run() {
        try {
//            System.out.println("Started: " + LocalDateTime.now());
//            Socket socket = new Socket("127.0.0.1", 25225);
            Socket socket = new Socket("localhost", 8080);
            BufferedReader br = new BufferedReader((new InputStreamReader(socket.getInputStream())));
            BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(socket.getOutputStream())));
            String command = COMMAND[cmdNumber % COMMAND.length];
//            Scanner scanner = new Scanner(System.in);
//            String s = scanner.nextLine();
//            String s = command + " Alexander!";
            String s = "GET / HTTP/1.1\r\nHost:java-course.ru\r\n\r\n";
            bw.write(s);
            bw.newLine();
            bw.flush();

            String answer = br.readLine();
            System.out.println("client got string:" + answer);

            br.close();
            bw.close();
//            System.out.println("Finished: " + LocalDateTime.now());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

