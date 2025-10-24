public class ThreadCreationDemo {
    public static void main(String[] args) {
        System.out.println("--- Bắt đầu Main Thread ---");
        System.out.println("Trạng thái của Main Thread: " + Thread.currentThread().getState()); // -> NEW

        // --- Cách 1: extends Thread ---
        MyThread threadA = new MyThread("Thread-A (extends)");
        System.out.println("Trạng thái của Thread-A: " + threadA.getState()); // -> NEW

        // --- Cách 2: implements Runnable ---
        MyRunnable runnableB = new MyRunnable("Thread-B (implements)");
        Thread threadB = new Thread(runnableB);
        System.out.println("Trạng thái của Thread-B: " + threadB.getState()); // -> NEW
        System.out.println("-----------------------------------------------");

        // Bắt đầu chạy cả 2 thread
        // Việc gọi start() sẽ đưa chúng vào trạng thái RUNNABLE
        threadA.start();
        threadB.start();

        System.out.println("Sau khi gọi start(), trạng thái Thread-A: " + threadA.getState()); // -> RUNNABLE
        System.out.println("Sau khi gọi start(), trạng thái Thread-B: " + threadB.getState()); // -> RUNNABLE
        System.out.println("-----------------------------------------------");

        // Main thread cũng là một thread!
        for (int i = 1; i <= 3; i++) {
            System.out.println("Main Thread đang chạy... " + i);
            try {
                Thread.sleep(1000); // Main thread tự vào TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("--- Main Thread kết thúc ---");
        // Lưu ý: Main thread có thể kết thúc trước cả threadA và threadB
    }
}
