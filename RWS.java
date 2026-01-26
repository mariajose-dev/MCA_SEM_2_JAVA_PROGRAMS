// Shared memory class
class SM {
    int data;
    boolean available = false;

    // Writer method
    public synchronized void write(int a) {
        try {
            // If previous data not yet read, writer waits
            while (available)
                wait();

            data = a;
            System.out.println("WROTE: " + data);
            available = true;

            notify();                 // notify reader
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    // Reader method
    public synchronized void read(String rid) {
        try {
            // If no data available, reader waits
            while (!available)
                wait();

            System.out.println("Reader " + rid + " READ: " + data);
            available = false;

            notifyAll();              // notify all waiting threads
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}

// Writer thread
class Writer extends Thread {
    SM q;

    public Writer(SM q) {
        this.q = q;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            q.write(i);
        }
    }
}

// Reader thread
class Reader extends Thread {
    SM q;
    String rid;   // Reader ID

    public Reader(SM q, String rid) {
        this.q = q;
        this.rid = rid;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            q.read(rid);
        }
    }
}

// Main class
class RWS {
    public static void main(String args[]) {

        SM q = new SM();

        Writer w1 = new Writer(q);
        Reader r1 = new Reader(q, "R1");
        Reader r2 = new Reader(q, "R2");

        w1.start();
        r1.start();
        r2.start();
    }
}
