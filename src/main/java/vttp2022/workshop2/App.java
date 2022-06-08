package vttp2022.workshop2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My ATM Machine - POSBank" );
        BankAccount bkAcc = new BankAccount("Brendon Bank Account");
        bkAcc.deposit("1000");
        System.out.println("My new account balance is: " + bkAcc.getBalance());
        bkAcc.withdraw("20");
        System.out.println("My new account balance is: " + bkAcc.getBalance());
        bkAcc.withdraw("980");
        System.out.println("My new account balance is: " + bkAcc.getBalance());
    }
}
