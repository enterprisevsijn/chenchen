public class Dog extends Animal {
    public boolean isVaccineInjected;

    @Override
    public String toString() {
        if(sexes) {

            if(isVaccineInjected){
                System.out.println("This is a cute dog , his name is "+name+"\nToday , he is "+age+" years old."+"\nHe has been VaccineInjected ."+"\nIf you want him to be your best friend , you just pay ￥ "+price);
            }
            else {
                System.out.println("This is a cute dog , his name is "+name+"\nToday , he is "+age+" years old."+"\nHe hasn't been VaccineInjected ."+"\nIf you want him to be your best friend , you just pay ￥ "+price);
            }
        }
        else {
            if(!isVaccineInjected){
                System.out.println( "This is a cute dog , her name is "+name+"\nToday , she is "+age+" years old."+"\nShe has been VaccineInjected ."+"\nIf you want her to be your best friend , you just pay ￥ "+price+"\nAttion ! Never can you hope her to become your girlfriend !");
            }
            else {
                System.out.println("This is a cute dog , her name is "+name+"\nToday , she is "+age+" years old."+"\nShe hasn't been VaccineInjected ."+"\nIf you want her to be your best friend , you just pay ￥ "+price+"\nAttion ! Never can you hope her to become your girlfriend !");
            }
        }
        return null;
    }

    public Dog(String ownname, int trueage, boolean ismale, boolean isVaccineInjected) {
        super(ownname, trueage, ismale, 100);
        this.isVaccineInjected = isVaccineInjected;
        kind="Dog";
        cost=5;
    }
}
