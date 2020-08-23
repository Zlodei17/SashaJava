
package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveron {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server started");
        try {
            Socket socket = serverSocket.accept();
            System.out.println("Client conected ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String reqest = bufferedReader.readLine();
            System.out.println("Request: "+ reqest);
            String response = "Helou from server"+reqest.length();
            System.out.println("Response: "+ response);
            bufferedWriter.write(response);
            bufferedWriter.flush();
            bufferedWriter.newLine();


            bufferedWriter.close();
            bufferedReader.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
