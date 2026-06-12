class Counter{
    int count;
    public synchronized void increment(){
        count++;
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Runnable a = () -> {
            for(int i=0; i<10000;i++){
                c.increment();
            }
        };

        Runnable b = () -> {
            for(int i=0; i<10000;i++){
                c.increment();
            }
        };
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

//        t1.setPriority(1);   // used to set the priority (min:1 to max:10)
//        System.out.println("t1 -> " + t1.getPriority()); //get the value of priority for particular thread
//        System.out.println("t2 -> " + t2.getPriority());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}

//class A extends Thread{
//    public void run(){
//        for(int i=0; i<5;i++){
//            System.out.println("Hi");
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//    }
//}
//
//class B extends Thread{
//    public void run(){
//        for(int i=0; i<5;i++){
//            System.out.println("Hello");
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}