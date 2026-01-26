// Printer class with print functionality
class CPrint {
    public synchronized void print(String s) {
	try{
        	System.out.println("Printing... [");
		Thread.sleep(1000);
        	System.out.println(s);
        	System.out.println("]");
	}catch(Exception e){
		System.out.println(e);
	}
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
        p.print(str);   // Call printer with synchronized access
    }
}

class pgm31 {
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
