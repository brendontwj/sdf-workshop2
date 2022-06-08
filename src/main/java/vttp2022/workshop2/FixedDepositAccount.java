package vttp2022.workshop2;

public class FixedDepositAccount extends BankAccount {

    private float interest = 3;
    private int duration = 6;

    private int durationInterestCounter;

    public FixedDepositAccount(String name, float initialAmount) {
        super(name, initialAmount);
        this.durationInterestCounter = 0;
    }

    public FixedDepositAccount(String name, float initialAmount, float interest) {
        super(name, initialAmount);
        this.interest = interest;
        this.durationInterestCounter =- 0;
    }

    public FixedDepositAccount(String name, float initialAmount, float interest, int duration) {
        super(name, initialAmount);
        this.interest = interest;
        this.duration = duration;
        this.durationInterestCounter = 0;
    }
    
    private void setDuration(int duration) {
        if(duration < 0){
             throw new IllegalArgumentException("Unsupported duration.");
        }

        this.duration = duration;
    }

    private void setInterest(float interest) {
        if(interest < 0){
             throw new IllegalArgumentException("Unsupported interest.");
        }

        this.interest = interest;
    }

    public void setDurationAndInterest(float interest, int duration){
        if(durationInterestCounter == 1){
             throw new IllegalArgumentException("Only can set duration" + " and interest once.");
        }
        setInterest(interest);
        setDuration(duration);
        durationInterestCounter++;
    }

    public float getInterest() {
        return interest;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    protected float withdraw(String withdrawalAmount) {
        return 0;
    }

    @Override
    protected void deposit(String depositAmount) {
        //NOP
    }

    @Override
    public float getBalance() {
        return (super.getBalance() + interest);
    }
}
