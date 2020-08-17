import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSoket {
    public static void main(String[] args) throws IOException {
        int caunt =0;
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true){

            System.out.println("Server accesso:" +(++caunt));
            Socket clientsocket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            BufferedWriter bufferedWriter  = new BufferedWriter(new OutputStreamWriter(clientsocket.getOutputStream()));

            String a = bufferedReader.readLine();
            String b = bufferedReader.readLine();
            String operations = bufferedReader.readLine();
            int sum = calculator(a, b,operations);
            String op = a + " "+ operations+ " " + b + " = " + sum;
            bufferedWriter.write(op);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedReader.close();
            bufferedWriter.close();
            clientsocket.close();



        }

    }
    private static int calculator(String a,String b, String operations){
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        switch (operations){
            case "+": return x+y;
            case "-": return x-y;
            case "*": return x*y;
            default: return  x/y;
        }
    }
}
