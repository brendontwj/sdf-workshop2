package vttp2022.workshop2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testBankAccount(){
        BankAccount bkAcc= new BankAccount("Kenneth Bank Acoount");
        bkAcc.deposit("1000");
        float finalBalance = bkAcc.withdraw("500");
        assertEquals(500, finalBalance, .1);
    }

    @Test
    public void testFixedDepositAccount(){
        try{
            FixedDepositAccount fdAcc = new FixedDepositAccount("My FD acc", 10000);
            System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(4, 12);
            System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(5, 6);
        }catch(IllegalArgumentException e){
            assertTrue("Only can set duration and interest once.".contains(e.getMessage()));
        }
    }    

    @Test
    public void testFixedDepositAccountInterestDuration() {
        FixedDepositAccount fdAcc = new FixedDepositAccount("My FD acc", 10000);
            System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            assertEquals(10003, fdAcc.getBalance(), 0.1);
            assertEquals(6, fdAcc.getDuration(), 0.1);
            assertEquals(3, fdAcc.getInterest(), 0.1);
            fdAcc.setDurationAndInterest(4, 12);
            assertEquals(12, fdAcc.getDuration(), 0.1);
            assertEquals(4, fdAcc.getInterest(), 0.1);
    }
}
