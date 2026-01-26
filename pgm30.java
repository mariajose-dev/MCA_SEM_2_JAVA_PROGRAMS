// Printer class with print functionality
class CPrint {
    public void print(String s) {
        System.out.println("Printing... [");
        System.out.println(s);
        System.out.println("]");
    }
}

// Thread class representing a print request
class PrintThread extends Thread {
    CPrint p;        // Shared printer object
    String str;      // Content to print

    // Constructor
    public PrintThread(CPrint p, String s) {
        this.p = p;
        this.str = s;
    }

    // Thread execution
    public void run() {
        p.print(str);   // Call printer without synchronization
    }
}

class pgm30 {
    public static void main(String args[]) {

        CPrint p = new CPrint();   // Single printer instance

        // Multiple threads using same printer
        PrintThread t1 = new PrintThread(p, "Hello");
        PrintThread t2 = new PrintThread(p, "World");
        PrintThread t3 = new PrintThread(p, "Good");

        // Start print jobs
        t1.start();
        t2.start();
        t3.start();
    }
}
