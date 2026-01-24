import java.lang.*;

class Thread1 extends Thread{
        public void run()
        {
            int i=0;
            for(i=0;i<5;i++)
            {
                System.out.println("Thread 1 value "+i);
            }
        }
}

class Thread2 extends Thread{
        public void run()
        {
            int i=0;
            for(i=0;i<3;i++)
            {
                System.out.println("Thread 2 value "+i);
            }
        }
}

class Thread_Sample{
    public static void main(String args[])
    {
        Thread1 t1=new Thread1();
        Thread2 t2=new Thread2();
        t1.start();
        t2.start();
    }
}