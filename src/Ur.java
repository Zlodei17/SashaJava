import java.io.IOException;

public class Ur {
    public static void main(String[] args) {
        Matema matema = new Matema();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    matema.suma();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    matema.numero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
