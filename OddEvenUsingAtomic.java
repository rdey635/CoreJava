import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenUsingAtomic {

    AtomicInteger nm = new AtomicInteger(0);
    AtomicBoolean chk = new AtomicBoolean(true);

    public static void main(String args[]) {
        final OddEvenUsingAtomic pc = new OddEvenUsingAtomic();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   if (pc.chk.get() == Boolean.TRUE) {
                        System.out.println("Odd: " + pc.nm.incrementAndGet());
                        pc.chk.compareAndSet(true, false);
                    }
                }

            }

        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) {
                    if (pc.chk.get() == Boolean.FALSE) {
                       System.out.println("Even: " + pc.nm.incrementAndGet());
                        pc.chk.compareAndSet(false, true);
                    }
                }

            }

        }).start();
    }
}
