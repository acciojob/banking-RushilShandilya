package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>maxWithdrawalLimit) throw new Exception("Maximum Withdraw Limit Exceed");
        if(amount>super.getBalance()) throw new Exception("Insufficient Balance");

        double getBalance = super.getBalance()-amount;
        if(getBalance<0) throw new Exception("Insufficient Balance");
        else super.setBalance(getBalance);

    }
    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return super.getBalance() + (super.getBalance()*rate*years)/100;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double principal = super.getBalance();
        double rateBy100 = rate/(100*times);
        double value = 1 + rateBy100;
        double compoundInterest = principal * Math.pow(value,years*times);
        return principal + compoundInterest;
    }
}
