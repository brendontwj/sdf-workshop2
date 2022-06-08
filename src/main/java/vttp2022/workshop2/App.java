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
        System.out.println("My new account balance is: " + bkAcc.withdraw("20"));
        System.out.println("My new account balance is: " + bkAcc.withdraw("980"));
        
        FixedDepositAccount fdAcc = new FixedDepositAccount("My FD Acc", 10000);
        System.out.println("Fixed Deposit Acc Balance > " + fdAcc.getBalance());

    }

    
    
}
