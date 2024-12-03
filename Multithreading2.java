class Process1 extends Thread {
    int x;

    
    public void run() {
        for (int x = 0; x <= 5; x++) {
            System.out.println("Process 1 : " + x);
        }
    }
}

class Process2 extends Thread {
    int x;

    
    public void run() {
        for (int x = 0; x <= 5; x++) {
            System.out.println("Process 2 : " + x);
        }
    }
}

public class Multithreading2 {
    public static void main(String[] args) {
        // Creating instances of the Process1 and Process2 threads.
        Process1 p1 = new Process1();
        Process2 p2 = new Process2();

        // Starting the threads.
        // This will call the run() method of each thread.
        p1.start();
        p2.start();
    }
}
