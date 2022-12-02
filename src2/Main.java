import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        recieve();
    }
    public static void recieve() throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        int n1=scanner.nextInt();
        int[]nums1 = new int[10];
        for (int i = 0; i < n1; i++) {
            nums1[i]=scanner.nextInt();
        }
        int n2=scanner.nextInt();
        int[]nums2 = new int[10];
        for (int i = 0; i < n2; i++) {
            nums2[i]=scanner.nextInt();
        }
        MyThread thread1=new MyThread(nums1,n1);
        MyThread1 thread2=new MyThread1(nums2,n2);
        thread1.start();
        thread2.start();



    }
}