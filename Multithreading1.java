class Process1 implements Runnable {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Process 1: " + i);
        }
    }
}

class Process2 implements Runnable {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Process 2: " + i);
        }
    }
}

public class Multithreading1 {
    public static void main(String[] args) {
        Process1 p1 = new Process1();
        Process2 p2 = new Process2();
        
        Thread t1 = new Thread(p1); // Pass Process1 instance to Thread
        Thread t2 = new Thread(p2); // Pass Process2 instance to Thread

        t1.start(); // Start the first thread
        t2.start(); // Start the second thread
    }
}
