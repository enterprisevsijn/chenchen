public class InsufficientBalanceException extends RuntimeException{
    private double balance;
    public InsufficientBalanceException(){
        super();
    }
    public InsufficientBalanceException(double balance){
        this.balance=balance;
    }
    @Override
    public String toString(){
        return "Happen InsufficientBalanceException!";
    }
}
