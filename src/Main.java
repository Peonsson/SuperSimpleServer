import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int PORT_NUMBER = 1337;

    public static void main(String[] args) {

        ServerSocket serverSocket;
        File file = new File("/Users/Peonsson/myData.txt");
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file);
            serverSocket = new ServerSocket(PORT_NUMBER);
            System.out.println("listening at.. " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
            Socket clientSocket = serverSocket.accept();
            System.out.println("got client! ");
            System.out.println(clientSocket.getInetAddress());
            System.out.println(clientSocket.getPort());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String str = "";
            while((str = reader.readLine()) != null) {
                System.out.println("got data: " + str);
                fileWriter.append(str);
            }
            fileWriter.close();
            System.out.println("returning..");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
