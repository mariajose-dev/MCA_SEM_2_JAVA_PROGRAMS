// Shared memory class
class SM {
    int data;
    boolean available = false;

    // Producer method
    public synchronized void put(int a) {
        try {
            // If data already present, producer waits as single-item buffer is full
            while (available)
                wait();

            data = a;
            System.out.println("PUT: " + data);
            available = true;

            notify();                 // notify one consumer
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    // Consumer method
    public synchronized void get(String cid) {
        try {
            // If no data available, consumer waits as single-item buffer is empty
            while (!available)
                wait();

            System.out.println("Consumer " + cid + " GET: " + data);
            available = false;

            notifyAll();              // notify all waiting threads
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}

// Producer thread
class Producer extends Thread {
    SM q;

    public Producer(SM q) {
        this.q = q;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            q.put(i);
        }
    }
}

// Consumer thread
class Consumer extends Thread {
    SM q;
    String cid;   // Consumer ID

    public Consumer(SM q, String cid) {
        this.q = q;
        this.cid = cid;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            q.get(cid);
        }
    }
}

// Main class
class PCS {
    public static void main(String args[]) {

        SM q = new SM();

        Producer p1 = new Producer(q);
        Consumer c1 = new Consumer(q, "A");
        Consumer c2 = new Consumer(q, "B");

        p1.start();
        c1.start();
        c2.start();
    }
}
