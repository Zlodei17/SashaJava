import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveer {
    public static void main(String[] args) throws IOException {
        int caunt = 0;
        ServerSocket serverSoket = new ServerSocket(8000);

        try {

            while (true){
                System.out.println("Server accessso!");
                Socket socket = serverSoket.accept();
                System.out.println("Client accesso Numero:" + (++caunt));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(socket.getOutputStream())));

                String a = bufferedReader.readLine();
                String b = bufferedReader.readLine();
                String operazione = bufferedReader.readLine();

                int sum = calc(a,b, operazione);
                String s = "Rezultato: summa = "+a+operazione+b+" = "+sum;
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                bufferedWriter.flush();


                bufferedReader.close();
                bufferedWriter.close();
                socket.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static int calc(String a, String b, String oper){
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            switch (oper){
                case "+": return x+y;
                case "-": return x-y;
                case "*": return x*y;
                default: return  x/y;
            }
    }
}
