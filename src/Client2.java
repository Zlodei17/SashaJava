import java.io.*;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        Client2 client = new Client2();
        System.out.println(client.getClass());
        int i = client.hashCode();
        System.out.println(i);
        try {
            Socket socket = new Socket("127.0.0.1",8000);
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("a:");
            String a =  bufferedReader1.readLine();
            System.out.println("b: ");
          String b = bufferedReader1.readLine();
            System.out.println("operazione: ");
          String oper = bufferedReader1.readLine();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


            bufferedWriter.write(a);
            bufferedWriter.newLine();
            bufferedWriter.flush();


            bufferedWriter.write(b);
            bufferedWriter.newLine();
            bufferedWriter.flush();


            bufferedWriter.write(oper);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String  sum = bufferedReader.readLine();

            System.out.println(sum);
            bufferedReader1.close();
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
