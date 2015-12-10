import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * SuperSimpleServer is a TCP server who accepts a client connection and writes clients message to a file.
 * Made by Peonsson 2015-12-10.
 */
public class Main {

    private static final int PORT_NUMBER = 1337;

    public static void main(String[] args) {

        ServerSocket serverSocket;
        FileWriter fileWriter;

        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                String date = new Date().toString();
                File file = new File("/Users/Peonsson/androidproject3b/" + date + ".txt");
                fileWriter = new FileWriter(file);
                System.out.println("got client! ");

//                System.out.println(clientSocket.getInetAddress());
//                System.out.println(clientSocket.getPort());

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String str;
                while ((str = reader.readLine()) != null) {
                    System.out.println("got data: " + str);
                    fileWriter.append(str);
                }

                fileWriter.close();
                System.out.println("returning..");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
