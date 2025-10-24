class MyRunnable implements Runnable {
    private String threadName;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        // Công việc y hệt như trên
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " đang chạy, đếm: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " KẾT THÚC.");
    }
}
