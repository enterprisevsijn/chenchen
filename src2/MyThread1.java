public class MyThread1 extends Thread{
    int[]nums;
    int num;
    int flag;
    MyThread1(int[]nums,int num){
        this.nums=nums;
        this.num=num;
        flag=0;
    }
    public void run() {
        for (int i = 0; i < num; i++) {
            synchronized (MyLock.object) {
                System.out.println(nums[i]);
                MyLock.object.notify();
                try {
                    if (i == num) {
                        return;
                    }
                    MyLock.object.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
