public class VolatileMain {
    // public static void main(String[] args) throws InterruptedException {
    //     VolatileData volatileData = new VolatileData();

    //     Thread t1 = new VolatileThread(volatileData);
    //     Thread t2 = new VolatileThread(volatileData);
    //     t1.start();
    //     Thread.sleep(1000);
    //     t2.start();
        
    //     try {
    //         t1.join();
    //         t2.join();
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    private final static int noOfThreads = 2;  
public static void main(String[] args) throws InterruptedException  
{  
        VolatileData volatileData = new VolatileData();     //object of VolatileData class  
        Thread[] threads = new Thread[noOfThreads];     //creating Thread array   
        for(int i = 0; i < noOfThreads; ++i)  
            threads[i] = new VolatileThread(volatileData);  
        for(int i = 0; i < noOfThreads; ++i)  
            threads[i].start();                 //starts all reader threads  
        for(int i = 0; i < noOfThreads; ++i)  
            threads[i].join();                  //wait for all threads  
}  
    
}
