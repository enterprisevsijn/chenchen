import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class MyAnimalShop implements AnimalShop{
    public double balance;
    public double primecost;
    public double income;
    public ArrayList<Animal>animalslist;

    public ArrayList<Customer> customerslist;
    public MyAnimalShop(double balance){
        this.balance=balance;
        primecost=100;
        animalslist=new ArrayList<Animal>(1000000);
        customerslist= new ArrayList<Customer>(1000000);
    }
    @Override
    public void purchase(int number) {
        boolean isrich=true;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < number; i++) {
            System.out.println("请输入待采购动物种类序号：1.中华田园犬(采购价 ￥5），2.猫(采购价 ￥3），3.猪(采购价 ￥15）");

            int change=scanner.nextInt();
                if(change==1){
                    this.balance=this.balance-5;
                    if (balance<=0){
                        try {
                            throw new InsufficientBalanceException(balance);
                        } catch (InsufficientBalanceException e) {
                            e.printStackTrace();
                        }
                        System.out.println("请立刻离开。");
                        isrich=false;
                        break;
                    }
                    primecost=primecost+5;
                    System.out.println("请输入狗子的基本信息：名字 年龄 性别（公TRUE 母FALSE） 注射狂犬病疫苗(是为1，非为0");
                    System.out.println("名字：");
                    String ownname=scanner.next();
                    System.out.println("年龄");
                    int age=scanner.nextInt();
                    System.out.println("性别");
                    boolean ismale=scanner.hasNext();
                    scanner.nextLine();
                    System.out.println("注射");
                    boolean isVaccineInjected=scanner.hasNextBoolean();
                    scanner.nextLine();
                    Dog dog= new Dog(ownname,age,ismale,isVaccineInjected);
                    animalslist.add(dog);
                }
                else if(change==2){
                    this.balance=this.balance-3;
                    if (balance<=0){
                        try {
                            throw new InsufficientBalanceException(balance);
                        } catch (InsufficientBalanceException e) {
                            e.printStackTrace();
                        }
                        System.out.println("请立刻离开。");
                        isrich=false;
                        break;
                    }
                    primecost=primecost+3;
                    System.out.println("请输入猫子的基本信息：名字 年龄 性别");
                    System.out.println("名字：");
                    String ownname=scanner.next();
                    System.out.println("年龄");
                    int age=scanner.nextInt();
                    System.out.println("性别");
                    boolean ismale=scanner.hasNext();
                    scanner.nextLine();
                    Cat cat= new Cat(ownname,age,ismale);
                    animalslist.add(cat);
                }
                else if(change==3){
                    this.balance=this.balance-15;
                    if (balance<=0){
                        try {
                            throw new InsufficientBalanceException(balance);
                        } catch (InsufficientBalanceException e) {
                            e.printStackTrace();
                        }
                        System.out.println("请立刻离开。");
                        isrich=false;
                        break;
                    }
                    primecost=primecost+15;
                    System.out.println("请输入猪猪的基本信息：名字 年龄 性别");
                    System.out.println("名字：");
                    String ownname=scanner.next();
                    System.out.println("年龄");
                    int age=scanner.nextInt();
                    System.out.println("性别");
                    boolean ismale=scanner.hasNext();
                    Pig pig= new Pig(ownname,age,ismale);
                    animalslist.add(pig);
                    scanner.nextLine();
                }
                else{
                    System.out.println("你是否清醒？");
                }
            if(!isrich){
                System.out.println("你因为囊中苦涩而提前结束进货");
                break;
            }
            scanner.nextLine();
        }
        System.out.println("已经完成采购");
    }

    @Override
    public void serve(int number) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("为欢迎顾客的到来，请输入顾客名字和来店频率");
        int i;
        for (i=0;i<number;i++) {
            String name=scanner.toString();
            scanner.nextLine();
            int frequency=scanner.nextInt();
            scanner.nextLine();
            if(i==animalslist.size()){
                try {
                    throw new AnimalNotFountException();
                }catch (AnimalNotFountException e){
                    e.printStackTrace();
                }
                System.out.println("本店宠物储量不足");
                rest();
                break;
            }
            String kind=animalslist.get(i).kind;
            Customer customer=new Customer(name,frequency,kind);
            customerslist.add(i,customer);
            animalslist.get(i).toString();
            this.income=this.income+animalslist.get(i).price-animalslist.get(i).cost;
            animalslist.remove(animalslist.get(i));
            //TODO：本处使用了两个ArrayList，但在进行对动物列表的删除即调用了remove(i)后，在循环到了最后一个Customer时会出现Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length

        }

    }


    @Override
    public void rest() {
        int number=customerslist.size();
        for (int i = 0; i < number; i++) {
            customerslist.get(i).toString();
        }
        System.out.println("Today,we get ￥"+income);

    }
}
