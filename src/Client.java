import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("Primo:");
        bufferedWriter.write(bufferedReader1.readLine());
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("Sekondo:");
        bufferedWriter.write(bufferedReader2.readLine());
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("Operazione:");
        bufferedWriter.write(bufferedReader3.readLine());
        bufferedWriter.newLine();
        bufferedWriter.flush();
        String sum = bufferedReader.readLine();
        System.out.println(sum);



        bufferedWriter.close();
        bufferedReader.close();
        socket.close();


    }
}
