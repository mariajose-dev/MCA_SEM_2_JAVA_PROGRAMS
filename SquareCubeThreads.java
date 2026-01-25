import java.util.Scanner;

// Thread to compute square
class Square implements Runnable {
    private int num;

    Square(int num) {
        this.num = num;
    }

    public void run() {
        int square = num * num;
        System.out.println("Square of " + num + " is: " + square);
    }
}

// Thread to compute cube
class Cube implements Runnable {
    private int num;

    Cube(int num) {
        this.num = num;
    }

    public void run() {
        int cube = num * num * num;
        System.out.println("Cube of " + num + " is: " + cube);
    }
}

public class SquareCubeThreads {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Create Runnable objects
        Square squareTask = new Square(num);
        Cube cubeTask = new Cube(num);

        // Create Thread objects
        Thread t1 = new Thread(squareTask);
        Thread t2 = new Thread(cubeTask);

        // Start threads
        t1.start();
        t2.start();
    }
}
