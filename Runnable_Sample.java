import java.lang.*;

class Thread1 implements Runnable{
        String name;
        Thread1(String name)
        {
            this.name=name;
        }
        public void run()
        {
            int i=0;
            for(i=0;i<5;i++)
            {
                System.out.println(name+" value is "+i);
            }
        }
}

class Runnable_Sample{
    public static void main(String args[])
    {
        Thread1 c1,c2;
        c1=new Thread1("Thread 1");
        c2=new Thread1("Thread 2");
        Thread t1=new Thread(c1);
        Thread t2=new Thread(c2);
        t1.start();
        t2.start();
    }
}