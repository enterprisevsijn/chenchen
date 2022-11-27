import java.io.Serializable;

public abstract class Animal implements Serializable {
    protected String kind;
    protected String name;
    protected int age;
    protected boolean sexes;//性别 1代表雄性 0代表雌性
    protected double price;
    protected double cost;
    Animal(String ownname,int trueage,boolean ismale,double willcost){
        name=ownname;
        age=trueage;
        sexes=ismale;
        price=willcost;
    }
}
