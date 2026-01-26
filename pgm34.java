// Thread class
class MyThread extends Thread {

    public MyThread(String name) {
        setName(name);              // Set thread name
    }

    public void run() {
        System.out.println(
            "Thread Name: " + getName() +
            " | Priority: " + getPriority()
        );
    }
}

class pgm34 {
    public static void main(String args[]) {

        // Create threads
        MyThread t1 = new MyThread("Low Priority Thread");
        MyThread t2 = new MyThread("Normal Priority Thread");
        MyThread t3 = new MyThread("Priority 7 Thread");
	MyThread t4 = new MyThread("High Priority Thread");

        // Set thread priorities
        t1.setPriority(Thread.MIN_PRIORITY);   // Priority = 1
        t2.setPriority(Thread.NORM_PRIORITY);  // Priority = 5
	t3.setPriority(Thread.NORM_PRIORITY+2);  // Priority = 7
        t4.setPriority(Thread.MAX_PRIORITY);   // Priority = 10

        // Start threads
        t1.start();
        t2.start();
        t3.start();
	t4.start();
    }
}
