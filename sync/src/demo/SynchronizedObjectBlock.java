package demo;

public class SynchronizedObjectBlock implements Runnable {

    static SynchronizedObjectBlock instance = new SynchronizedObjectBlock();

    Object lock1 = new Object();
    Object lock2 = new Object();


    @Override
    public void run() {


        /**
         * 使用对象锁和类锁
         */
        synchronized (lock1){
            System.out.println("我是lock1，我叫"+ Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock1---finished");

        }

        synchronized (lock1){
            System.out.println("我是lock2，我叫"+ Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock2----finished");

        }


    }

    public static void main(String[] args){
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");


    }
}
