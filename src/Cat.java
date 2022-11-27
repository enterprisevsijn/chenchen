public class Cat extends Animal {

    @Override
    public String toString() {
        if(sexes==true) {
            System.out.println( "This is a cute cat , his name is "+name+"\nToday , he is "+age+" years old."+"\nIf you want him to be your best friend , you just pay ￥ "+price);
        }
        else {
            System.out.println("This is a cute cat , her name is "+name+"\nToday , she is "+age+" years old."+"\nIf you want her to be your best friend , you just pay ￥ "+price+"\nAttion ! Never can you hope her to become your girlfriend !");
        }
        return null;
    }

    public Cat(String ownname, int trueage, boolean ismale) {
        super(ownname, trueage, ismale, 200);
        kind="Cat";
        cost=3;
    }
}
