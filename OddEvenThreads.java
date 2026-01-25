import java.util.Scanner;

// Thread to print odd numbers
class OddNumbers implements Runnable {
    private int N;

    OddNumbers(int N) {
        this.N = N;
    }

    public void run() {
        System.out.println("Odd numbers up to " + N + ":");
        for (int i = 1; i <= N; i += 2) {
            System.out.print("Thread 1 Odd is "+i + "\n");
            try {
                Thread.sleep(200); // pause to show interleaving
            } catch (InterruptedException e) {
                System.out.println("Odd thread interrupted");
            }
        }
        System.out.println();
    }
}

// Thread to print even numbers
class EvenNumbers implements Runnable {
    private int N;

    EvenNumbers(int N) {
        this.N = N;
    }

    public void run() {
        System.out.println("Even numbers up to " + N + ":");
        for (int i = 2; i <= N; i += 2) {
            System.out.print("Thread 2 Even is "+i + "\n");
            try {
                Thread.sleep(200); // pause to show interleaving
            } catch (InterruptedException e) {
                System.out.println("Even thread interrupted");
            }
        }
        System.out.println();
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();

        // Create Runnable objects
        OddNumbers oddTask = new OddNumbers(N);
        EvenNumbers evenTask = new EvenNumbers(N);

        // Create Thread objects
        Thread t1 = new Thread(oddTask);
        Thread t2 = new Thread(evenTask);

        // Start threads
        t1.start();
        t2.start();
        sc.close();
    }
}
