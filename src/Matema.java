import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matema {
    double a = 0;
    double b =0;
    String oprerazione ;
    double sum =0;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public synchronized void  suma() throws InterruptedException{
        try {
            System.out.println("iniziamo");
            wait();
            System.out.println("sum = " + a + oprerazione+b + " = "+ sum );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public synchronized void numero() throws InterruptedException{
        System.out.println("Buon gorno. questo e calkulatore!");
        System.out.println("Primo numero x: ");
        try {
            a = Double.parseDouble(bufferedReader.readLine());
            System.out.println("Secondo numero y: ");
            b = Double.parseDouble(bufferedReader.readLine());
            System.out.println("Operazione: ");
            oprerazione = bufferedReader.readLine();
            bufferedReader.close();
            sum =calc();



        } catch (IOException e) {
            e.printStackTrace();
        }
        notify();

    }
    public double calc(){
        switch (oprerazione){
            case "+":
                return  sum = a + b;
            default:
                return  sum = a - b;
        }
    }

}
