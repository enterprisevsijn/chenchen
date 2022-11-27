public class Pig extends Animal{
    @Override
    public String toString() {
        if(sexes==true) {
            System.out.println("This is a cute cat , his name is "+name+"\nToday , he is "+age+" years old."+"\nIf you want him to be your best friend , you just pay ￥ "+price+".\nAs a result , if you feel hungry , you can taste your friend .");
        }
        else {
            System.out.println("This is a cute cat , her name is "+name+"\nToday , she is "+age+" years old."+"\nIf you want her to be your best friend , you just pay ￥ "+price+".\nAs a result , if you feel hungry , you can taste your friend ."+"\nAttion ! Never can you hope her to become your girlfriend !");
        }
        return null;
    }
    public Pig(String ownname,int trueage,boolean ismale){
        super(ownname,trueage,ismale,1000);
        kind="Pig";
        cost=15;
    }

}
