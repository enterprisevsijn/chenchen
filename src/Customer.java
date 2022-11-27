import java.time.LocalDate;

public class Customer {
    public String name;
    public int frequency;
    public LocalDate data;
    public String buykind;
    public Customer(String name,int frequency,String buykind){
        this.name=name;
        this.frequency=frequency;
        this.buykind=buykind;
        data=LocalDate.now();
    }
    @Override
    public String toString(){
        System.out.println("The customer , "+name+" , need a animal to be a pet . ");
        System.out.println("This is the "+frequency+" times that the customer come into our shop .");
        System.out.println("最新到店时间是"+data);
        System.out.println("buy a "+buykind);
        return null;
    }
}
