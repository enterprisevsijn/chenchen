import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Hello world! You open your shop , please tell us your balance :");
        double balance = scanner.nextDouble();
        MyAnimalShop shop=new MyAnimalShop(balance);
        System.out.println("你打算采购的动物数量：");
        int number=scanner.nextInt();
        shop.purchase(number);
        System.out.println("=============================================");
        System.out.println("输入进店人数：");
        int people=scanner.nextInt();
        scanner.nextLine();
        shop.serve(people);
        shop.rest();
    }
}