class MyThread extends Thread {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        // Công việc mà thread này sẽ làm
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " đang chạy, đếm: " + i);
            try {
                // Tạm dừng 1 chút để thấy rõ sự xen kẽ
                Thread.sleep(500); // -> Chuyển sang trạng thái TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " KẾT THÚC."); // -> Chuyển sang TERMINATED
    }
}
